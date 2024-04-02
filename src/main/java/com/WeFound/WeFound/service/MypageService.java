package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.PointRepository;
import com.WeFound.WeFound.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.List;

@Service
public class MypageService {

    private final PointRepository pointRepository;
    private final UserRepository userRepository;

    public MypageService(PointRepository pointRepository, UserRepository userRepository) {
        this.pointRepository = pointRepository;
        this.userRepository = userRepository;
    }

    public void populateModelWithUserDetails(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String email = userDetails.getEmail();
            String nickName = userDetails.getNickName();

            // 권한(role) 정보 가져오기
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


    // 포인트 내역
    public List<Point> getPointHistoryForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            Long userId = userDetails.getUserId();
            User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
            return pointRepository.findByUserOrderByCreatedAtDesc(user);
        }
        return List.of();
    }
}