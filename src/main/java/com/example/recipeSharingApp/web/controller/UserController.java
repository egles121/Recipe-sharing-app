package com.example.recipeSharingApp.web.controller;

import com.example.recipeSharingApp.business.service.UserService;
import com.example.recipeSharingApp.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipeSharing/user")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getComments() {
        List<User> list = userService.getUsers();
        if (list.isEmpty()) {
            log.info ("The user list is empty: {}", list);
            return ResponseEntity.notFound().build();
        }
        else {
            log.info ("Users were found: {}", list.size());
            return ResponseEntity.ok(list);
        }
    }
    /*
    Create user

    Get user by id

    Update user by id

    Delete user by id
     */

}
