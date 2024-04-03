


package com.WeFound.WeFound.like;




import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.QuestionRepository;
       //  .NotFoundException
       // .DuplicateResourceException;

import com.WeFound.WeFound.like.LikeRequestDTO;
import com.WeFound.WeFound.like.Like;
import com.WeFound.WeFound.like.LikeRepository;

import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final QuestionRepository boardRepository;

    @Transactional

//@Transactional 그리고 비즈니스 로직 실행
//①클래스의 메소드, ②클래스, ③인터페이스의 메소드, ④인터페이스 순위




    public void insert(LikeRequestDTO likeRequestDTO) throws Exception {

        User user = UserRepository.findById(LikeRequestDTO.getUserId())
                .orElseThrow(() -> new NotFoundException("예외처리" + LikeRequestDTO.getUserId()));

        Question question = QuestionRepository.findById(LikeRequestDTO.getquestionId())
                .orElseThrow(() -> new NotFoundException("예외처리" + LikeRequestDTO.getQuestionId()));



        // 이미 좋아요 되어있으면 에러 반환이 된다
        if (LikeRepository.findByUserAndBoard(user, question).isPresent()){
            //TODO 409에러로 변경
            throw new DuplicateResourceException("오류반환" + user.getId() + " ,"
                    + "question id 는= " + question.getId());
        }

        Like like = Like.builder()
                .question(question)
                .user(user)
                .build();

        LikeRepository.save(like);
        QuestionRepository.addLikeCount(board);
    }


    @Transactional
    public void delete(LikeRequestDTO likeRequestDTO) {

        User user = UserRepository.findById(LikeRequestDTO.getUserId())
                .orElseThrow(() -> new NotFoundException("찾을 수 없습니다" + likeRequestDTO.getUserId()));

        Question question = QuestionRepository.findById(LikeRequestDTO.getQuestionId())
                .orElseThrow(() -> new NotFoundException("찾을 수 없습니다" + likeRequestDTO.getQuestionId()));

        Like like = likeRepository.findByUserAndQuestion(user, question)
                .orElseThrow(() -> new NotFoundException("찾을 수 없습니다"));

        likeRepository.delete(like);
        QuestionRepository.subLikeCount(question);
    }
}
