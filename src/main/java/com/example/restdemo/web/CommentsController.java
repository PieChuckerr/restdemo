package com.example.restdemo.web;

import com.example.restdemo.model.Comment;
import com.example.restdemo.resource.CommentResource;
import com.example.restdemo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/messages/{messageId}/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @GetMapping(value ="/",  produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Resources<CommentResource>> getAllComments(@PathVariable("messageId") long messageId){
        List<Comment> comments = commentsService.getAllCommentsAgainsMessages(messageId);
        List<CommentResource> commentResources = new ArrayList<>();
        for(Comment comment : comments) {
            commentResources.add(new CommentResource(messageId,comment));
        }
        Resources<CommentResource> resources = new Resources<CommentResource>(commentResources);
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value ="/{commentId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<CommentResource> getAllComment(@PathVariable("messageId") long messageId, @PathVariable("commentId") long commentId){
        Comment comment = commentsService.getComment(messageId, commentId);
        CommentResource commentResource = new CommentResource(messageId, comment);
        return ResponseEntity.ok(commentResource);
    }

    @PostMapping(value ="/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<CommentResource> getPostComment(@PathVariable("messageId") long messageId, @RequestBody Comment comment){
        Comment persistedComment = commentsService.addComment(messageId, comment);
        CommentResource commentResource = new CommentResource(messageId, persistedComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResource);
    }
}
