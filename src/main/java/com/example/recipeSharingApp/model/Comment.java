package com.example.recipeSharingApp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
    /*
    Comment (parameters: commentId, userId (who made the comment), recipeId (where the comment is published), commentText)
     */
    @Id
    private Long id;

    private Long userId;

    private Long recipeId;

    private String commentText;

    public Comment() {
    }

    public Comment(Long id, Long userId, Long recipeId, String commentText) {
        this.id = id;
        this.userId = userId;
        this.recipeId = recipeId;
        this.commentText = commentText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
