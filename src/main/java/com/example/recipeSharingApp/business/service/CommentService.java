package com.example.recipeSharingApp.business.service;

import com.example.recipeSharingApp.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getComments();


    Optional<Comment> getCommentById(Long id);

    void deleteCommentById(Long id);
}
