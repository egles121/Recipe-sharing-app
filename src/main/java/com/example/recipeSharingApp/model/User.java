package com.example.recipeSharingApp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class User {
    /*
    User (parameters: id, name, list of recipes, list of comments)
     */

    private Long id;

    private String name;

    private List<Recipe> recipes;

    private List<Comment> comments;

}
