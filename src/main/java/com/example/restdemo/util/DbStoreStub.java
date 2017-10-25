package com.example.restdemo.util;

import com.example.restdemo.model.Message;
import com.example.restdemo.model.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DbStoreStub {
    public Map<Long, Message> messageMap = new HashMap<>();
    public Map<Long, Profile> profileMap = new HashMap<>();
    public static long nextProfileId;
    public static long nextMessageId;

    {
        profileMap.put(1L,new Profile(1L,"Govinda"));
        profileMap.put(2L,new Profile(2L,"Mick"));
        profileMap.put(3L,new Profile(3L,"Scott"));
        messageMap.put(1L,new Message(1L,"Hello",1));
        messageMap.put(2L,new Message(2L,"Hello World!",1));
        messageMap.put(3L,new Message(3L,"Hello World Govinda!",3));
        nextMessageId = 3L;
        nextProfileId =  3L;
    }



    public static long getProfileId() {
        return ++nextProfileId;
    }

    public static long getMessaageId() {
        return ++nextMessageId;
    }
}
