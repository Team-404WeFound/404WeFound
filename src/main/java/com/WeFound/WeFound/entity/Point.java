package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
@EntityListeners(AuditingEntityListener.class)
@Table(name = "points")
@Getter
@Setter
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id",updatable = false)
    private Long pointId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "point")
    private Long point;


    @Column(name = "reason")
    private String reason;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;



    public Point() {

    }
}
