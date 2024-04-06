



package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Like;
import com.WeFound.WeFound.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    void deleteByIdAndQuestion(Long id, Question question);


    /*
    Optional<Like> findByUserAndQuestionId(User user, Question question);
    */

   /* Like findByUserIdAndQuestionId(Long user_Id, Long question_Id);*/


}/*
    @Repository
    public interface LikeRepository extends JpaRepository<Like, Long> {


        void deleteByUserAndQuestion(Long user_id, Long question_id);
       Optional<Like> findByUserAndQuestion(User user, Question question);
    }

*/

