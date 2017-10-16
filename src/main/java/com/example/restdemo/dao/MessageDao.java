package com.example.restdemo.dao;

import com.example.restdemo.model.Message;

import java.util.List;

public interface MessageDao {
    public Message findById(long id);

    Message delete(long id);

    Message persist(Message message);

    Message update(Long id, Message message);

    List<Message> getAllTheMessages();
}
