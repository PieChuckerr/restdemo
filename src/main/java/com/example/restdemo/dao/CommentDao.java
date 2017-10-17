package com.example.restdemo.dao;

import com.example.restdemo.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getCommentsByMessage(long messageId);


    Comment getCommentById(long messageId, long commentId);

    Comment persist(long messageId, Comment comment);
}
