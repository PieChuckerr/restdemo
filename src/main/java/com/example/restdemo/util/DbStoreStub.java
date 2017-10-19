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
    public long id;

    {
        messageMap.put(1L,new Message(1L,"Hello"));
        messageMap.put(2L,new Message(2L,"Hello World!"));
        messageMap.put(3L,new Message(3L,"Hello World Govinda!"));
        id = 3L;
    }

    public static long getProfileId() {
        return ++nextProfileId;
    }
}
