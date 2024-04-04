



package com.WeFound.WeFound.controller;



import com.WeFound.WeFound.entity.Like;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.dto.LikeRequest;
import com.WeFound.WeFound.dto.LikeResponse;
import com.WeFound.WeFound.service.LikeService;
import com.WeFound.WeFound.service.UserService;

import lombok.RequiredArgsConstructor;
//필드의 생성자를 자동 생성해주는 롬복
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/{user}")
public class LikeController {
    private final LikeService likeService;
     final UserService userService;

    @PostMapping("/likes")
    public ResponseEntity<LikeResponse> addLike(
            @AuthenticationPrincipal User user,
            @RequestBody LikeRequest request
    ) {
        Like like = new Like(user, request.getQuestionId());
        likeService.addLike(like);
        LikeResponse response = new LikeResponse(like);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/likes")
    public ResponseEntity<Void> deleteLike(
            @AuthenticationPrincipal User user,
            @RequestBody LikeRequest request
    ) {

       likeService.deleteLike(user.getUserId(), request.getQuestionId());
        return ResponseEntity.ok().build();
    }
}












/* 실패3
@RequiredArgsConstructor
@RequestMapping("/boards/{id}")
public class LikeController {
    private final LikeService likeService;
    private final UserService UserService;

  @PostMapping("/likes")
    public ResponseEntity<LikeResponse> addLike(
            @AuthenticationPrincipal User user,
            @RequestBody LikeRequest request
    ) {
      Like like = new Like(user, request.getQuestionId());
        LikeService.addLike(like);
        LikeResponse response = new LikeResponse(like);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/likes")
    public ResponseEntity<Void> deleteLike(
            @AuthenticationPrincipal User user,
            @RequestBody LikeRequest request
    ) {
        LikeService.deleteLike(user.getUserId(), request.questionId());
        return ResponseEntity.ok().build();
    }
}
*/




 /*   실패1

 @PostMapping("/likes")
    public ResponseEntity<LikeResponse> addLike(
            @AuthenticationPrincipal User user,
            @RequestBody LikeRequest request
    ) {
        User currentUser = userService.findByUserId(user.getUserId());
        Like like = new Like(currentUser, request.getQuestionId());
        likeService.addLike(like);
        LikeResponse response = new LikeResponse(like);
        return ResponseEntity.ok(response);
    }

*/













/* 실패2

@Transactional
public String updateLikeOfBoard(final Long id, final Member member) {
    Board board = boardRepository.findById(id)
            .orElseThrow(BoardNotFoundException::new);

    if (!hasLikeBoard(board, member)) {
        board.increaseLikeCount();
        return createLikeBoard(board, member);
    }

    board.decreaseLikeCount();
    return removeLikeBoard(board, member);
}

private String removeLikeBoard(final Board board, final Member member) {
    LikeBoard likeBoard = likeBoardRepository.findByBoardAndMember(board, member)
            .orElseThrow(LikeHistoryNotfoundException::new);

    likeBoardRepository.delete(likeBoard);

    return SUCCESS_UNLIKE_BOARD;
}*/
