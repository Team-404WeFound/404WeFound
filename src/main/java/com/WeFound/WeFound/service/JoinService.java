package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.JoinDto;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDto joinDto) {


        User data = new User();

        data.setEmail(joinDto.getEmail());
        data.setNickname(joinDto.getNickname());
        data.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
        data.setRole("ROLE_USER");


        userRepository.save(data);
    }
}