package com.example.restdemo.daoimpl;

import com.example.restdemo.dao.MessageDao;
import com.example.restdemo.model.Message;
import com.example.restdemo.util.DbStoreStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class MessageDaoJdbc implements MessageDao {

    @Autowired
    DbStoreStub dbStoreStub;

    @Override
    public Message findById(long id){
        return dbStoreStub.messageMap.get(id);
    }

    @Override
    public Message delete(long id){
        return dbStoreStub.messageMap.remove(id);
    }

    @Override
    public Message persist(Message message){
        message.setId(DbStoreStub.getMessaageId());
        dbStoreStub.messageMap.put(message.getId(),message);
        return message;
    }

    @Override
    public Message update(Long id,Message message){
        message.setId(id);
        return dbStoreStub.messageMap.put(id,message);
    }

    @Override
    public List<Message> getAllTheMessages(){
        return new ArrayList<Message>(dbStoreStub.messageMap.values());
    }

    @Override
    public List<Message> getMessageSentByProfileId(long profileId) {
        Set<Long> messageIds = dbStoreStub.messageMap.keySet();
        List<Message> messages = new ArrayList<>();
        for(Message message: messages) {
            if(message.getSentByProfileId()==profileId) {
                messages.add(message);
            }
        }
        return  messages;
    }
}
