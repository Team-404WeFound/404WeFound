package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> findByUserOrderByCreatedAtDesc(User user);
}