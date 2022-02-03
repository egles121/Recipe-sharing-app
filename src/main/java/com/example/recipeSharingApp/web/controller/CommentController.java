package com.example.recipeSharingApp.web.controller;

import com.example.recipeSharingApp.business.service.CommentService;
import com.example.recipeSharingApp.business.service.impl.CommentServiceImpl;
import com.example.recipeSharingApp.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recipeSharing/comment")
public class CommentController {
    /*
    Create comment

    Update comment by id



    Get all comments by recipeId

    Get all comments by userId
     */

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    //Delete comment by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteCommentById(Long id) {
        Optional<Comment> selectedComment = commentService.getCommentById(id);
        if (selectedComment.isPresent() && selectedComment != null)
            commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }

}
