package com.example.restdemo.serviceimpl;

import com.example.restdemo.dao.CommentDao;
import com.example.restdemo.model.Comment;
import com.example.restdemo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> getAllCommentsAgainsMessages(long messageId) {
        return commentDao.getCommentsByMessage(messageId);
    }

    @Override
    public Comment getComment(long messageId,long commentId) {
        return commentDao.getCommentById(messageId,commentId);
    }

    @Override
    public Comment addComment(long messageId, Comment comment) {
        return commentDao.persist(messageId, comment);
    }
}
