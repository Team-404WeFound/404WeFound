package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;

@Service
public class MainService {

    public void populateModelWithUserDetails(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String email = userDetails.getEmail();
            String nickName = userDetails.getNickName();

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = null;
            if (!authorities.isEmpty()) {
                role = authorities.iterator().next().getAuthority();
            }

            model.addAttribute("email", email);
            model.addAttribute("nickName", nickName);
            model.addAttribute("role", role);
        }
    }
}