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
    private Long userId;

    @Column(name = "friend_id")
    private Long friendId;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    public Friend(Long userId,Long friendId,LocalDateTime createAt){
        this.userId = userId;
        this.friendId = friendId;
        this.createAt = createAt;
    }
}
