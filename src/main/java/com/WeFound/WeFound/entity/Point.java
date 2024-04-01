package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "point")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id",updatable = false)
    private Long pointId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "point")
    private Long point;

    @Column(name = "reason")
    private Long reason;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public Point(Long pointId,Long userId,Long point,Long reason,LocalDateTime createAt){
        this.pointId = pointId;
        this.userId = userId;
        this.point = point;
        this.reason = reason;
        this.createAt = createAt;
    }

}
