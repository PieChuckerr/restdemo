package com.example.restdemo.web;

import com.example.restdemo.model.Message;
import com.example.restdemo.resource.MessageResource;
import com.example.restdemo.service.MessageService;
import com.example.restdemo.util.DbStoreStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity <Resources< MessageResource >> getAll(){
        List<Message> messages = messageService.getAllMessages();
        List<MessageResource> messageResources = new ArrayList<>();

        for (Message msg: messages) {
            messageResources.add(new MessageResource(msg));
        }

        Resources<MessageResource> messageResourceEntities = new Resources<>(messageResources);
        return ResponseEntity.ok(messageResourceEntities);
    }

    @PostMapping(value="/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> sendMessage(@RequestBody Message message){
        MessageResource messageResource = new MessageResource(messageService.sendMessage(message));
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(messageResource.message.getId()).toUri();
        messageResource.add();
        return ResponseEntity.created(uri).body(messageResource);
    }

    @GetMapping(value="/{msgId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getMessageById(@PathVariable("msgId") long msgId){
        MessageResource messageResource = new MessageResource(messageService.getMessageById(msgId));
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(messageResource.message.getId()).toUri();
        messageResource.add();
        return ResponseEntity.ok(messageResource);
    }

    @PutMapping(value="/{msgId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> updateMessageById(@PathVariable("msgId") long msgId, @RequestBody Message message){
        MessageResource messageResource = new MessageResource(messageService.updateMessage(msgId,message));
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(messageResource.message.getId()).toUri();
        return ResponseEntity.created(uri).body(messageResource);
    }

    @DeleteMapping(value="/{msgId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> deleteMessageById(@PathVariable("msgId") long msgId){
         messageService.getDeleteById(msgId);
        return ResponseEntity.status(204).build();
    }

    @GetMapping(value="/add/{firstNumber}/{secondNumber}", produces = MediaType.TEXT_PLAIN)
    public ResponseEntity<Double> add(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber)
    {
        if(!firstNumber.matches(".*\\d+.*"))
            throw new NumberFormatException("First value is not number");
        else if(!secondNumber.matches(".*\\d+.*"))
            throw new NumberFormatException("First value is not number");

        return ResponseEntity.ok(Double.parseDouble(firstNumber)+Double.parseDouble(secondNumber));
    }
}

/*
@RestController
@RequestMapping(value = "/people", produces = "application/hal+json")
public class PersonController {
    final PersonRepository personRepository;
    public PersonController(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @GetMapping public ResponseEntity < Resources < PersonResource >> all() {
        final List < PersonResource > collection = personRepository.findAll().stream().map(PersonResource::new).collect(Collectors.toList());
        final Resources < PersonResource > resources = new Resources < > (collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }
    @GetMapping("/{id}") public ResponseEntity < PersonResource > get(@PathVariable final long id) {
        return personRepository.findById(id).map(p - > ResponseEntity.ok(new PersonResource(p))).orElseThrow(() - > new PersonNotFoundException(id));
    }
    @PostMapping public ResponseEntity < PersonResource > post(@RequestBody final Person personFromRequest) {
        final Person person = new Person(personFromRequest);
        personRepository.save(person);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(new PersonResource(person));
    }
    @PutMapping("/{id}") public ResponseEntity < PersonResource > put(@PathVariable("id") final long id, @RequestBody Person personFromRequest) {
        final Person person = new Person(personFromRequest, id);
        personRepository.save(person);
        final PersonResource resource = new PersonResource(person);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(resource);
    }
    @DeleteMapping("/{id}") public ResponseEntity << ? > delete(@PathVariable("id") final long id) {
        return personRepository.findById(id).map(p - > {
                personRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        }).orElseThrow(() - > new PersonNotFoundException(id));
    }
}*/
