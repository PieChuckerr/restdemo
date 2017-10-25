package com.example.restdemo.model;

import org.springframework.security.access.method.P;

public class Profile {
    long id;
    String name;

    public Profile(){

    }

    public Profile(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
