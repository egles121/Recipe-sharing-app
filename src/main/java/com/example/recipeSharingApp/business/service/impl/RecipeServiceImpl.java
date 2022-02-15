package com.example.recipeSharingApp.business.service.impl;

import com.example.recipeSharingApp.business.repository.RecipeRepository;
import com.example.recipeSharingApp.business.service.RecipeService;
import com.example.recipeSharingApp.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }
}
