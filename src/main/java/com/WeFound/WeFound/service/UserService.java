package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddUserdto;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    public void save(AddUserdto request) {
        userRepository.save(new User(
                request.getEmail(),encoder.encode(request.getPassword())));
    }



    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    public List<AddUserdto> findAll() {
        List<User> memberEntityList = userRepository.findAll();
        List<AddUserdto> memberDTOList = new ArrayList<>();
        for (User memberEntity: memberEntityList) {
            memberDTOList.add(AddUserdto.addUserdto(memberEntity));

        }
        return memberDTOList;
    }
    public AddUserdto findById(Long id) {
        Optional<User> optionalMemberEntity = userRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {

            return AddUserdto.addUserdto(optionalMemberEntity.get());
        } else {
            return null;
        }

    }

}
