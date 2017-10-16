package com.example.restdemo.resource;

import com.example.restdemo.web.MessageController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import com.example.restdemo.model.Message;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class MessageResource extends ResourceSupport {
    public final Message message;
    public MessageResource(Message message){
        this.message = message;
        add(ControllerLinkBuilder.linkTo(MessageController.class).withRel("messages"));
        add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(MessageController.class).getMessageById(message.getId())).withRel("self"));
    }
}
