



package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Like;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.entity.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/*
    @Repository
    public interface LikeRepository extends JpaRepository<Like, Long> {


        void deleteByUserAndQuestion(Long user_id, Long question_id);
       //Optional<Like> findByUserAndQuestion(User user, Question question);
    }

*/


@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    void deleteByUserIdAndQuestionId(Long user_id, Long question_id);

   /* Like findByUserIdAndQuestionId(Long userid, Long questionid);*/
}