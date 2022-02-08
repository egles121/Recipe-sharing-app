package com.example.recipeSharingApp.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Comment {
    /*
    Comment (parameters: commentId, userId (who made the comment), recipeId (where the comment is published), commentText)
     */
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "3"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
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

    public Comment(Long userId, Long recipeId, String commentText) {
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
