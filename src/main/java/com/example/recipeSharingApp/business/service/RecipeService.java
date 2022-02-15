package com.example.recipeSharingApp.business.service;

import com.example.recipeSharingApp.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAllRecipes();
}
