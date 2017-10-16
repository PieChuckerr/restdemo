package com.example.restdemo.serviceimpl;

import com.example.restdemo.dao.MessageDao;
import com.example.restdemo.model.Message;
import com.example.restdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Override
    public List<Message> getAllMessages() {
        return messageDao.getAllTheMessages();
    }

    public MessageServiceImpl() {
        super();
    }

    @Override
    public Message sendMessage(Message message) {
        return messageDao.persist(message);
    }

    @Override
    public Message getMessageById(long messageId) {
        return messageDao.findById(messageId);
    }

    @Override
    public Message getDeleteById(long messageId) {
        return messageDao.findById(messageId);
    }

    public Message updateMessage(long msgId, Message message){
        return messageDao.update(msgId,message);
    }

}
