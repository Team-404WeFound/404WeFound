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



    //0405 추가 합니다
public Optional<User> findById(Long id){
        return userRepository.findById(id);

}




    public void withdrawUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        userRepository.delete(user);
    }
}
