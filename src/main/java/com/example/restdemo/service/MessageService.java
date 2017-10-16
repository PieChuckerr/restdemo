package com.example.restdemo.service;


import com.example.restdemo.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();
    Message sendMessage(Message message);
    Message getMessageById(long msgId);
    Message getDeleteById(long msgId);
    Message updateMessage(long msgId, Message message);
}
