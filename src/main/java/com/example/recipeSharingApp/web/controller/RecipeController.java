package com.example.recipeSharingApp.web.controller;

import com.example.recipeSharingApp.business.service.RecipeService;
import com.example.recipeSharingApp.model.Recipe;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipeSharing/recipe")
@Log4j2
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> findAllRecipes() {
        List<Recipe> list = recipeService.findAllRecipes();
        if (list.isEmpty()) {
            log.info("The recipe list is empty: {}", list);
            return ResponseEntity.notFound().build();
        } else {
            log.info("Recipes were found: {}", list.size());
            return ResponseEntity.ok(list);
        }
    }
    /*
    Create recipe

    Get recipe by id

    Update recipe by id

    Delete recipe by id

    Get all recipes made by user by userId
     */
}
