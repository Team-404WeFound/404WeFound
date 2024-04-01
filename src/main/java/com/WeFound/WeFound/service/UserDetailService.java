package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User userData = userRepository.findByEmail(email);

        if (userData != null) {

            //return new CustomUserDetails(userData);
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return null;
    }

}