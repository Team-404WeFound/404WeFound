



package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Like;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.AccessLevel;

@Data

@NoArgsConstructor
@Getter

public class LikeRequest {

    private Long userId;
    private Long questionId;


    }



