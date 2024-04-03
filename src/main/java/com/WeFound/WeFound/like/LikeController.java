package com.WeFound.WeFound.like;


import com.WeFound.WeFound.like.HttpResponseEntity;
import com.WeFound.WeFound.like.HttpResponseEntity.ResponseResult;

import static com.WeFound.WeFound.like.HttpResponseEntity.success;

import lombok.RequiredArgsConstructor;
//필드의 생성자를 자동 생성해주는 롬복
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor

@RequestMapping("/WeFound/like")


public class LikeController {

    private final LikeService likeService;


//HttpEntity 클래스를 상속 -> RequestEntity, ResponseEntity 클래스
//https://tecoble.techcourse.co.kr/post/2021-05-10-response-entity/



    @PostMapping
    public ResponseResult<?> insert(@RequestBody @Valid LikeRequestDTO likeRequestDTO) throws Exception {
        likeService.insert(likeRequestDTO);
        return success();
    }

//insert 메서드 좋아요 +1하는 역활
//success - Response 응답 성공 여부 성공하면 true, 실패하면 false


    @DeleteMapping
    public ResponseResult<?> delete(@RequestBody @Valid LikeRequestDTO likeRequestDTO) {
        likeService.delete(likeRequestDTO);
        return success();
    }

}


//delete 메서드 좋아요 -1하는 역활
