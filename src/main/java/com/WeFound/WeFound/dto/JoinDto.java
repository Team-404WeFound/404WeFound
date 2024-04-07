package com.WeFound.WeFound.dto;


//0407추가
import lombok.*;

/* //0407변경
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
*/



@Setter
@Getter

//0407어노테이션추가
@AllArgsConstructor
@NoArgsConstructor

public class JoinDto {

    private String email;
    private String password;
    private String nickName;
}