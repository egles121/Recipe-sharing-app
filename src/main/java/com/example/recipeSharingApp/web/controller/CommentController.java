package com.example.recipeSharingApp.web.controller;

import com.example.recipeSharingApp.business.service.CommentService;
import com.example.recipeSharingApp.model.Comment;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recipeSharing/comment")
@Log4j2
public class CommentController {
    /*

    Get all comments by recipeId

    Get all comments by userId
     */

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> list = commentService.getComments();
        if (list.isEmpty()) {
            log.info ("The comments list is empty: {}", list);
            return ResponseEntity.notFound().build();
        }
        else {
            log.info ("Comments were found: {}", list.size());
            return ResponseEntity.ok(list);
        }
    }

    //Delete comment by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteCommentById(@PathVariable @NonNull Long id) {
        Optional<Comment> selectedComment = commentService.getCommentById(id);
        if (selectedComment.isPresent()) {
            log.info ("Comment with id {} has been deleted", id);
            commentService.deleteCommentById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            log.info ("Comment with id {} was not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    //create comment
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        log.info("Comment has been created: {}", comment);
        commentService.addComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    //update comment by id
    @PutMapping("/{id}")
    public ResponseEntity<Comment> editComment (@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> selected = commentService.getCommentById(id);
        if (selected.isPresent() && Objects.equals(comment.getId(), id)) {
            log.info("Comment with id {} was edited {}:", id, comment);
            Comment newComment = commentService.editComment(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body(newComment);
        }
        else {
            log.info("Comment with id {} was not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
