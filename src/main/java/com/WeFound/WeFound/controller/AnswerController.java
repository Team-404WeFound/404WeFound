package com.WeFound.WeFound.controller;


import com.WeFound.WeFound.dto.*;
import com.WeFound.WeFound.dto.AnswerResponseDto;
import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.AdminService;
import com.WeFound.WeFound.service.AnswerService;
import com.WeFound.WeFound.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api")
public class AnswerController {

    private final AnswerService answerService;
    private final UserService userService;
    private final AdminService adminService;

    public AnswerController(AnswerService answerService,UserService userService,AdminService adminService) {
        this.answerService = answerService;
        this.userService = userService;
        this.adminService = adminService;
    }

    /**
     * 댓글 작성
     * @param question_id 게시물
     * @param answerRequestDTO 답글 정보
    // * @param authentication 유저 정보
     * @return 게시물 상세 페이지
     */
//    @PostMapping("/questions/{question_id}/answer")
//    public ResponseEntity<AnswerResponseDto> writeAnswer(@PathVariable Long question_id, @RequestBody AnswerRequestDto answerRequestDTO) {
//        // 현재 사용자의 Authentication 객체 가져오기
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        // 현재 사용자의 이름 가져오기
//        String username = authentication.getName();
//
//        // answerService.writeAnswer 메서드 호출하여 답글 작성
//        Long answerId = answerService.writeAnswer(answerRequestDTO, question_id);
//
//        // 생성된 답변의 ID를 사용하여 응답 구성
//        AnswerResponseDto responseDTO = new AnswerResponseDto();
//        responseDTO.setAnswerId(answerId); // 답변의 ID 설정
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
//    }


    @PostMapping("/questions/{question_id}/answer")
    public ResponseEntity<AnswerResponseDto> writeAnswer(@PathVariable Long question_id, @RequestBody AnswerRequestDto answerRequestDTO,@AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = userDetails.getUserId();
        answerRequestDTO.setUser_id(userId);
        Answer answer= answerService.writeAnswer(answerRequestDTO,question_id);


        // 생성된 답변의 ID를 사용하여 응답 구성
        //writeAnswer 진행시 즉 answer작성시 answer작성한 user에게 포인트 10L 주기로 함
        adminService.updateUserPoint(userId,0L,"AnswerController");
        AnswerResponseDto responseDTO = new AnswerResponseDto();
        responseDTO.setAnswerId(question_id); // 답변의 ID 설정

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
//    /**
//     * 댓글 단권 조회
//     * @param question_id 게시물 ID
//     * @param answerRequestDTO 수정할 답변 정보
//     * @return 수정된 답변의 상세 페이지
//     */
//    @GetMapping("/questions/{question_id}/answer")
//    public ResponseEntity<List<AnswerResponseDTO>> showAllAnswer(){
//        List<Answer> answerList = answerService.findAll();
//        List<AnswerResponseDTO> responseDTOList = answerList
//                .stream().map(AnswerResponseDTO::new)
//                .toList();
//        return ResponseEntity.ok(responseDTOList);
//    }

    /**
     * 댓글 단권 조회
     //* @param question_id 게시물 ID
     * @param answer_id 답변 ID
    //* @param answerRequestDTO 수정할 답변 정보
     * @return 수정된 답변의 상세 페이지
     */
    @GetMapping("/questions/{question_id}/answer/{answer_id}")
    public ResponseEntity<AnswerResponseDto> showOneAnswer(@PathVariable Long answer_id){
        Answer answer = answerService.findById(answer_id);
        return ResponseEntity.ok(answer.toResponse());
    }

    /**
     * 댓글 수정
     * @param question_id 게시물 ID
     * @param answer_id 답변 ID
     * @param answerRequestDTO 수정할 답변 정보
     * @return 수정된 답변의 상세 페이지
     */
    @PutMapping("/questions/{question_id}/answer/{answer_id}/update")
    public ResponseEntity<AnswerResponseDto> updateAnswer(@PathVariable Long question_id, @PathVariable Long answer_id, @RequestBody AnswerRequestDto answerRequestDTO) {
        // 서비스의 updateAnswer 메서드 호출하여 수정된 답변을 받아옴
        AnswerResponseDto responseDTO = answerService.updateAnswer(answer_id, answerRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * 댓글 삭제
     * @param question_id 게시물 ID
     * @param answer_id 답변 ID
     * @return 게시물 상세 페이지로 리다이렉트
     */
    @DeleteMapping("/questions/{question_id}/answer/{answer_id}/remove")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long question_id, @PathVariable Long answer_id) {
        answerService.deleteAnswer(answer_id);
        return ResponseEntity.ok().build();
    }
}
