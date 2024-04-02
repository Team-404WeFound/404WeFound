package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;

    @Autowired
    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserGrade(Long userId, String grade) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        user.setGrade(grade);
        userRepository.save(user);
    }

    public void updateUserPoint(Long userId, Long point) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        user.setPoint(point);
        userRepository.save(user);
    }
}