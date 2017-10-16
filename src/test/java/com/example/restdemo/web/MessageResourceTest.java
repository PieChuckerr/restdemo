package com.example.restdemo.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.restdemo.model.Message;
import com.example.restdemo.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import  static org.springframework.test.web.servlet.MockMvc.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MessageService messageService;

    @Test
    public void getAllMessageHappyTest() throws Exception{
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(1,"Hello"));
        messageList.add(new Message(5,"Hello world"));
        messageList.add(new Message(3,"Hello World, G!"));

        when(messageService.getAllMessages()).thenReturn(messageList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/messages/").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("####"+messageService.getAllMessages());
        System.out.println("****"+ mvcResult.toString());
        String expected = "{\"id\":1,\"message\":\"Hello\"}";
        JSONAssert.assertEquals(expected,mvcResult.toString(),false);
    }
}
