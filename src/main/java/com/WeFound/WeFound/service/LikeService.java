


package com.WeFound.WeFound.service;




import com.WeFound.WeFound.entity.Like;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.LikeRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;




    @Transactional
    public void addLike(Like like) {
        likeRepository.save(like);
    }

@Transactional
   public void deleteLike(Long user_id, Question  question) {
        likeRepository.deleteByIdAndQuestion(user_id, question); }









/*
@Transactional
    public void deleteLike(Like like) {
        likeRepository.delete(like);
*/
     /*   public Like findLike(Long user_id, Long question_id) {
            return likeRepository.findByUserIdAndQuestionId(user_id, question_id);  }  */


        }






