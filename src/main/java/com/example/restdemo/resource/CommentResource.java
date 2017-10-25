package com.example.restdemo.resource;

import com.example.restdemo.model.Comment;
import com.example.restdemo.web.CommentsController;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class CommentResource extends ResourceSupport {
    private long messageId;
    private Comment comment;

    public CommentResource() {

    }

    public CommentResource(long messageId, Comment comment) {
        this.messageId = messageId;
        this.comment = comment;
        add(ControllerLinkBuilder.linkTo(CommentsController.class).withRel("comments"));
        add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CommentsController.class).getAllComment(messageId,comment.getCommentId())).withSelfRel());
    }
}
