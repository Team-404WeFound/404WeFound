package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.WeFound.WeFound.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public void updateUserGrade(User user) { // 포인트 변경이 감지되면
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

//0406추가
    public Optional<User> findById(Long id){
        return userRepository.findById(id);

    }


    public void withdrawUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        userRepository.delete(user);
    }
}
