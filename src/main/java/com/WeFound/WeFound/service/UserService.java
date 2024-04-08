package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findNickNameByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public void updateUserGrade(User user) {
        Long totalPoint = user.getPoint();

        if (totalPoint >= 100) {
            user.setGrade("grade3");
        } else if (totalPoint >= 50) {
            user.setGrade("grade2");
        } else {
            user.setGrade("grade1");
        }

        userRepository.save(user);
    }

    public void withdrawUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        userRepository.delete(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}