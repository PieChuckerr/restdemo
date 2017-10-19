package com.example.restdemo.model;

public class Comment {

    long commentId;
    String comment;
    long sentByProfileId;

    public long getSentByProfileId() {
        return sentByProfileId;
    }

    public void setSentByProfileId(long sentByProfileId) {
        this.sentByProfileId = sentByProfileId;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        Comment comment1 = (Comment) o;

        if (commentId != comment1.commentId) return false;
        if (sentByProfileId != comment1.sentByProfileId) return false;
        return comment != null ? comment.equals (comment1.comment) : comment1.comment == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (commentId ^ (commentId >>> 32));
        result = 31 * result + (comment != null ? comment.hashCode () : 0);
        result = 31 * result + (int) (sentByProfileId ^ (sentByProfileId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                ", sentByProfileId=" + sentByProfileId +
                '}';
    }
}
