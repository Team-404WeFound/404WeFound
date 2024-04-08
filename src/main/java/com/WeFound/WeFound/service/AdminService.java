package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.PointRepository;
import com.WeFound.WeFound.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final PointRepository pointRepository;
    private final UserService userService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserGrade(Long userId, String grade) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        user.setGrade(grade);
        userRepository.save(user);
    }

    public void updateUserPoint(Long userId, Long point, String reason) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));

        Point pointData = new Point();
        pointData.setUser(user);
        pointData.setPoint(point);
        pointData.setReason(reason);
        pointRepository.save(pointData);

        Long totalPoint = user.getPoint() + point;
        user.setPoint(totalPoint);

        userService.updateUserGrade(user);
        userRepository.save(user);
    }
}