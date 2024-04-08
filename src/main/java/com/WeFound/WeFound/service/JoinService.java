package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.JoinDto;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto) {
        boolean isUser = userRepository.existsByEmail(joinDto.getEmail());
        if (isUser) {
            return;
        }

        User data = new User();
        data.setEmail(joinDto.getEmail());
        data.setNickName(joinDto.getNickName());
        data.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
        data.setGrade("grade1");
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}