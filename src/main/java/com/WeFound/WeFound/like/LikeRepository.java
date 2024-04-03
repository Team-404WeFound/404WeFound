



package com.WeFound.WeFound.like;


import com.WeFound.WeFound.like.Like;

import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.entity.Question;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndQuestion(User user, Question question);
}
