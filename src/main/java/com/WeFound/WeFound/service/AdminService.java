package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.PointRepository;
import com.WeFound.WeFound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final PointRepository pointRepository;
    private final UserService userService;

    @Autowired
    public AdminService(UserRepository userRepository, PointRepository pointRepository, UserService userService) {
        this.userRepository = userRepository;
        this.pointRepository = pointRepository;
        this.userService = userService;
    }
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

        // "QuestionController"일 때만 포인트가 10점 증가하도록 조건을 추가합니다.
        if ("QuestionController".equals(reason)) {
            Long totalPoint = pointRepository.findByUserOrderByCreatedAtDesc(user)
                    .stream()
                    .mapToLong(Point::getPoint)
                    .sum() + 10; // 10점 증가
            user.setPoint(totalPoint);
        } else {
            Long totalPoint = pointRepository.findByUserOrderByCreatedAtDesc(user)
                    .stream()
                    .mapToLong(Point::getPoint)
                    .sum();
            user.setPoint(totalPoint);
        }


//        Long totalPoint = pointRepository.findByUserOrderByCreatedAtDesc(user)
//                .stream()
//                .mapToLong(Point::getPoint)
//                .sum();
//
//        user.setPoint(totalPoint);

        userService.updateUserGrade(user);
        userRepository.save(user);
    }
}