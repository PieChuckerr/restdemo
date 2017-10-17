package com.example.restdemo.daoimpl;

import com.example.restdemo.dao.CommentDao;
import com.example.restdemo.model.Comment;
import com.example.restdemo.model.Message;
import com.example.restdemo.util.DbStoreStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoJdbc implements CommentDao {

    @Autowired
    DbStoreStub dbStoreStub;

    @Override
    public List<Comment> getCommentsByMessage(long messageId) {
        return dbStoreStub.messageMap.get(messageId).getComments();
    }

    @Override
    public Comment getCommentById(long messageId, long commentId) {
        Message message = dbStoreStub.messageMap.get(messageId);
        for (Comment comment : message.getComments()) {
            if (comment.getCommentId() == commentId) {
                return comment;
            }
        }
        return  null;
    }

    @Override
    public Comment persist(long messageId, Comment comment) {
        Message message = dbStoreStub.messageMap.get(messageId);
        message.setCommentId(message.getCommentId());
        comment.setCommentId(message.getCommentId());
        message.getComments().add(comment);
        return comment;
    }
}
