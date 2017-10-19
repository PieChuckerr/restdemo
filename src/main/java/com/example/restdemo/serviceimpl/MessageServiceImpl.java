package com.example.restdemo.serviceimpl;

import com.example.restdemo.dao.MessageDao;
import com.example.restdemo.dao.ProfileDao;
import com.example.restdemo.exception.ProfileNotFoundException;
import com.example.restdemo.model.Message;
import com.example.restdemo.model.Profile;
import com.example.restdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Autowired
    ProfileDao profileDao;

    @Override
    public List<Message> getAllMessages() {
        return messageDao.getAllTheMessages();
    }

    public MessageServiceImpl() {
        super();
    }

    @Override
    public Message sendMessage(Message message) {
        Profile profile = profileDao.get (message.getSentByProfileId ());

        if(profile == null) {
            throw new ProfileNotFoundException ("No profile found for the profile ID:" +message.getSentByProfileId ());
        }

        profile = profileDao.get (message.getSentToProfileId ());

        if(profile == null) {
            throw new ProfileNotFoundException ("No profile found for the profile ID:" +message.getSentToProfileId ());
        }

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
