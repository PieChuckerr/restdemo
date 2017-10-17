package com.example.restdemo.service;


import com.example.restdemo.model.Comment;

import java.util.List;

public interface CommentsService {
    List<Comment> getAllCommentsAgainsMessages(long messageId);

    Comment getComment(long messageId, long commentId);

    Comment addComment(long messageId, Comment comment);
}
