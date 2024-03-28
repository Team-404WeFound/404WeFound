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

    @Column(name = "user_id",updatable = false)
    private Long user_id;

    @Column(name = "point",updatable = false)
    private Long point;

    @Column(name = "reason",updatable = false)
    private Long reason;

    @Column(name = "create_at",updatable = false)
    private LocalDateTime create_at;


}
