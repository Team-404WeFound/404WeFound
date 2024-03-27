package com.WeFound.WeFound.dto;

import lombok.Getter;
import lombok.Setter;

//회원가입 구현을 위해 dto 파일에 작성
public class AddUserdto {
    @Getter
    @Setter
    private String email;
    private String password;


    public String getPassword() {
        return password;
    }
}
