package com.example.restdemo.daoimpl;

import com.example.restdemo.dao.MessageDao;
import com.example.restdemo.model.Message;
import com.example.restdemo.util.DbStoreStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        message.setId(++dbStoreStub.id);
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
}
