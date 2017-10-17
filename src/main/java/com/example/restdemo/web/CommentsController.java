package com.example.restdemo.web;

import com.example.restdemo.model.Comment;
import com.example.restdemo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/messages/{messageId}/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @RequestMapping(value ="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Comment> getAllComments(@PathVariable("messageId") long messageId){
        System.out.println(commentsService.getAllCommentsAgainsMessages(messageId));
        return commentsService.getAllCommentsAgainsMessages(messageId);
    }

    @RequestMapping(value ="/{commentId}", method = RequestMethod.GET)
    public Comment getAllComment(@PathVariable("messageId") long messageId, @PathVariable("commentId") long commentId){
        return commentsService.getComment(messageId, commentId);
    }

    @RequestMapping(value ="/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Comment getPostComment(@PathVariable("messageId") long messageId, @RequestBody Comment comment){
        return commentsService.addComment(messageId, comment);
    }

}
