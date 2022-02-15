package com.example.recipeSharingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("comments")
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("comments")
    private Recipe recipe;

    private String commentText;

    public Comment() {
    }

    public Comment(String commentText) {
        this.commentText = commentText;
    }

    public Comment(User user, String commentText) {
        this.user = user;
        this.commentText = commentText;
    }

    public Comment(User user, Recipe recipe, String commentText) {
        this.user = user;
        this.recipe = recipe;
        this.commentText = commentText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getRecipeId() {
        return recipe.getId();
    }

    public void setRecipeId(Long id) {
        recipe.setId(id);
    }

    public Long getUserId() {
        return user.getId();
    }

    public void setUserId(Long id) {
        user.setId(id);
    }
}
