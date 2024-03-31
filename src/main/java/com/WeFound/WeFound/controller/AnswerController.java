package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AnswerRequestDTO;
import com.WeFound.WeFound.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;


    /**
     * 댓글 작성
     * @param id 게시물
     * @param answerRequestDTO 답글 정보
     * @param authentication 유저 정보
     * @return 게시물 상세 페이지
     */
    //게시판 질문답변 작성
    @PostMapping("/questions/{id}/answer")
    public String writeAnswer(@PathVariable Long id, AnswerRequestDTO answerRequestDTO, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        answerService.writeAnswer(answerRequestDTO, id, userDetails.getUsername());

        return "redirect:/qustions/"+id;
    }

    //게시판 질문답변 수정
    @ResponseBody
    @PostMapping("/questions/{id}/answer/{answer_id}/update")
    public String updateAnswer(@PathVariable Long id,@PathVariable Long answer_id,AnswerRequestDTO answerRequestDTO){
        answerService.updateAnswer(answerRequestDTO,answer_id);
        return "/questions/"+id;
    }

    /**
     * 댓글 삭제
     * @param id 게시물
     * @param answer_id 답글 ID
     * @return 해당 게시물 리다이렉트
     */

    //게시판 질문답변 삭제
    @GetMapping("/questions/{id}/answer/{answer_id}/remove")
    public String deleteAnswer(@PathVariable Long id,@PathVariable Long answer_id){
        answerService.deleteAnswer(answer_id);
        return "redirect:/questions/" + id;
    }
}
