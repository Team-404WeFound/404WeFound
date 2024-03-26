package com.WeFound.WeFound.service;

import com.WeFound.WeFound.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

}
