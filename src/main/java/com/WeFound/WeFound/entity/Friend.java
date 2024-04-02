package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table(name = "friend")
@NoArgsConstructor
@Getter
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",updatable = false)
    private Long user_id;

    @Column(name = "friend_id")
    private Long friend_id;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime create_at;

    public Friend(Long user_id,Long friend_id,LocalDateTime create_at){
        this.user_id = user_id;
        this.friend_id = friend_id;
        this.create_at = create_at;
    }
}
