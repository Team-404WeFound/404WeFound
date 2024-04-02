package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//회원가입 구현을 위해 dto 파일에 작성
public class AddUserdto {

    private Long user_id;
    private String email;
    private String password;


    public static AddUserdto addUserdto(User user){
        AddUserdto addUserdto = new AddUserdto();
        addUserdto.setUser_id(user.getUser_id());
        addUserdto.setEmail(user.getEmail());
        addUserdto.setPassword(user.getPassword());

        return addUserdto;
    }

}
