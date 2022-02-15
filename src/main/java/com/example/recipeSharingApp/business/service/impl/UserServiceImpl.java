package com.example.recipeSharingApp.business.service.impl;

import com.example.recipeSharingApp.business.repository.UserRepository;
import com.example.recipeSharingApp.business.service.UserService;
import com.example.recipeSharingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
