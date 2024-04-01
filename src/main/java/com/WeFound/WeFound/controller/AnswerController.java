package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AnswerRequestDTO;
import com.WeFound.WeFound.dto.AnswerResponseDTO;
import com.WeFound.WeFound.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    /**
     * 댓글 작성
     * @param id 게시물
     * @param answerRequestDTO 답글 정보
     * @param authentication 유저 정보
     * @return 게시물 상세 페이지
     */
    @PostMapping("/questions/{id}/answer")
    public ResponseEntity<AnswerResponseDTO> writeAnswer(@PathVariable Long id, @RequestBody AnswerRequestDTO answerRequestDTO, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long answerId = answerService.writeAnswer(answerRequestDTO, id, userDetails.getUsername());

        // 생성된 답변의 ID를 사용하여 응답 구성
        AnswerResponseDTO responseDTO = new AnswerResponseDTO();
        responseDTO.setAnswerId(id); // 답변의 ID 설정

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    /**
     * 댓글 수정
     * @param id 게시물 ID
     * @param answer_id 답변 ID
     * @param answerRequestDTO 수정할 답변 정보
     * @return 수정된 답변의 상세 페이지
     */
    @PutMapping("/questions/{id}/answer/{answer_id}/update")
    public ResponseEntity<AnswerResponseDTO> updateAnswer(@PathVariable Long id, @PathVariable Long answer_id, @RequestBody AnswerRequestDTO answerRequestDTO) {
        // 서비스의 updateAnswer 메서드 호출하여 수정된 답변을 받아옴
        AnswerResponseDTO responseDTO = answerService.updateAnswer(answer_id, answerRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * 댓글 삭제
     * @param id 게시물 ID
     * @param answer_id 답변 ID
     * @return 게시물 상세 페이지로 리다이렉트
     */
    @DeleteMapping("/questions/{id}/answer/{answer_id}/remove")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id, @PathVariable Long answer_id) {
        answerService.deleteAnswer(answer_id);
        return ResponseEntity.ok().build();
    }
}
