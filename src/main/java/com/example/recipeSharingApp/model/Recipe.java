package com.example.recipeSharingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String recipeText;

    @ManyToOne
    @JsonIgnoreProperties("recipes")
    private User user;

    /*@OneToMany(
            /*
            mappedBy - field that owns the relationship, because in comment entity we have the recipe reference
            cascade - each operation preformed on the recipe will be propagated to the items that
            are stored in the comment list e.g. recipe entity and we have some comments assigned to it, all the comments
            will also be persisted to the db
            orphanRemoval - if we have the recipe and we remove it the comments associated with it will be removed
            from the db
            *//*
            mappedBy = "recipe",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )*/
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recipe")
    @JsonIgnoreProperties("recipe")
    private List<Comment> comments = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String name, String recipeText, User user) {
        this.name = name;
        this.recipeText = recipeText;
        this.user = user;
    }

    public Recipe(String name, String recipeText) {
        this.name = name;
        this.recipeText = recipeText;
    }

    public Recipe(String name, String recipeText, List<Comment> comments) {
        this.name = name;
        this.recipeText = recipeText;
        this.comments = comments;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public Long getUserId() {
        return user.getId();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
