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
    private Long point_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "point")
    private Long point;

    @Column(name = "reason")
    private Long reason;

    @Column(name = "create_at")
    private LocalDateTime create_at;

    public Point(Long point_id,Long user_id,Long point,Long reason,LocalDateTime create_at){
        this.point_id = point_id;
        this.user_id = user_id;
        this.point = point;
        this.reason = reason;
        this.create_at = create_at;
    }

}
