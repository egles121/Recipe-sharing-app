package com.example.recipeSharingApp.business.service.impl;

import com.example.recipeSharingApp.business.repository.CommentRepository;
import com.example.recipeSharingApp.business.service.CommentService;
import com.example.recipeSharingApp.model.Comment;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment editComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
