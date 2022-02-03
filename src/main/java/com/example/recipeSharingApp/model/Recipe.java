package com.example.recipeSharingApp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    /*
    Recipe (parameters: id, name, recipeText, user (who made the recipe), list of comments)
     */

    private Long id;

    private String name;

    private String recipeText;

    private User user;

    private List<Comment> comments;
}
