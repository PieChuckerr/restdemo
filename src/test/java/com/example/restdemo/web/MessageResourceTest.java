package com.example.restdemo.web;

import com.example.restdemo.model.Message;
import com.example.restdemo.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MessageService messageService;

    List<Message> messageList = new ArrayList<>();

    @Before
    void setupMessages() {
        messageList.add(new Message(1,"Hello",1));
        messageList.add(new Message(5,"Hello world",1));
        messageList.add(new Message(3,"Hello World, G!",3));
    }

    @Test
    public void getAllMessageHappyTest() throws Exception{
        when(messageService.getAllMessages()).thenReturn(messageList);

        mockMvc.perform(get("/messages/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].message", is("Hello")))
                .andExpect(jsonPath("$[1].sentByProfileId", is(1)))
                .andExpect(jsonPath("$[0].id", is(5)))
                .andExpect(jsonPath("$[0].message", is("Hello world")))
                .andExpect(jsonPath("$[1].sentByProfileId", is(1)))
                .andExpect(jsonPath("$[0].id", is(3)))
                .andExpect(jsonPath("$[0].message", is("Hello World, G!")))
                .andExpect(jsonPath("$[1].sentByProfileId", is(3)));


        verify(messageService, times(1)).getAllMessages();
        verifyNoMoreInteractions(messageService);
    }

    @Test
    public void sendMessage() throws Exception {
        Message msg = new Message(1,"New msg sent!",4);
        when(messageService.sendMessage(msg)).thenReturn(msg);
        when(messageService.sendMessage(null)).thenThrow(new RuntimeException("Message not in a valid format exception"));

        mockMvc.perform(
                post("/messages/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(messageService, times(1)).sendMessage(msg);
        verifyNoMoreInteractions(messageService);
    }
}
