



package com.WeFound.WeFound.like;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

//@NoArgsConstructor (access = AccessLevel.PROTECTED) =생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단

public class LikeRequestDTO {

    private Long userId;
    private Long questionId;

    public LIkeRequestDTO(Long userId, Long  questionId) {
        this.userId = userId;
        this.questionId =  questionId;
    }
}
