package com.example.recipeSharingApp;

import com.example.recipeSharingApp.business.repository.CommentRepository;
import com.example.recipeSharingApp.business.repository.RecipeRepository;
import com.example.recipeSharingApp.business.repository.UserRepository;
import com.example.recipeSharingApp.model.Comment;
import com.example.recipeSharingApp.model.Recipe;
import com.example.recipeSharingApp.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RecipeSharingAppApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(RecipeSharingAppApplication.class, args);


        CommentRepository commentRepository = configurableApplicationContext.getBean(CommentRepository.class);

        RecipeRepository recipeRepository = configurableApplicationContext.getBean(RecipeRepository.class);

        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);

        User user = new User("cool_guy123");
        User user2 = new User("cakeQueen");

        Recipe recipe1 = new Recipe("Lasagna", "put it in the oven", user);
        List<Recipe> recipes = Arrays.asList(recipe1);

        Comment comment1 = new Comment(user, recipe1, "lol");
        List<Comment> userComments1 = Arrays.asList(comment1);

        Comment comment2 = new Comment(user2, recipe1, "awesome recipe! Thanks for sharing");
        List<Comment> userComments2 = Arrays.asList(comment2);

        user.setComments(userComments1);
        user.setRecipes(recipes);
        userRepository.save(user);

        user2.setComments(userComments2);
        userRepository.save(user2);

        List<Comment> recipeComments = Arrays.asList(comment1,comment2);
        recipe1.setComments(recipeComments);
        recipeRepository.save(recipe1);
    }
}
