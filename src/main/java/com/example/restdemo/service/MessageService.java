package com.example.restdemo.service;


import com.example.restdemo.exception.ProfileException;
import com.example.restdemo.exception.ProfileNotFoundException;
import com.example.restdemo.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();
    Message sendMessage(Message message) throws ProfileException;
    Message getMessageById(long msgId);
    Message getDeleteById(long msgId);
    Message updateMessage(long msgId, Message message);
}
