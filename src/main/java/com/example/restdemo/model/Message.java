package com.example.restdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Message {
    long id;
    long sentByProfileId;

    @JsonIgnore
    int commentId=0;
    String message;

    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId++;
    }

    public Message(long id, String message, long sentByProfileId) {
        this.id = id;
        this.message = message;
        this.sentByProfileId = sentByProfileId;
    }

    public long getSentByProfileId() {
        return sentByProfileId;
    }

    public void setSentByProfileId(long sentByProfileId) {
        this.sentByProfileId = sentByProfileId;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        Message message1 = (Message) o;

        if (id != message1.id) return false;
        if (sentByProfileId != message1.sentByProfileId) return false;
        if (commentId != message1.commentId) return false;
        if (message != null ? !message.equals (message1.message) : message1.message != null) return false;
        return comments != null ? comments.equals (message1.comments) : message1.comments == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (sentByProfileId ^ (sentByProfileId >>> 32));
        result = 31 * result + commentId;
        result = 31 * result + (message != null ? message.hashCode () : 0);
        result = 31 * result + (comments != null ? comments.hashCode () : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sentByProfileId=" + sentByProfileId +
                ", commentId=" + commentId +
                ", message='" + message + '\'' +
                ", comments=" + comments +
                '}';
    }
}
