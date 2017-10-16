package com.example.restdemo.model;

public class Message {
    long id;
    String message;

    public Message(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
