package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Iterator;

@Service
public class MainService {

    public void populateModelWithUserDetails(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String email = userDetails.getEmail();
            String nickname = userDetails.getNickname();

            // 권한(role) 정보 가져오기
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = null;
            if (!authorities.isEmpty()) {
                role = authorities.iterator().next().getAuthority();
            }

            model.addAttribute("email", email);
            model.addAttribute("nickname", nickname);
            model.addAttribute("role", role);
        }
    }
}