package org.example.blogproject.user;

import lombok.Data;

public class UserRequest {

    // 회원가입 요청
    @Data
    public static class JoinDTO{
        private String username;
        private String password;
        private String passwordCheck;
        private String email;
        private String phone;

        public User toEntity(){
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .phone(phone)
                    .build();
        }
    }

    // 로그인 요청
    @Data
    public static class LoginDTO{
        private String username;
        private String password;
    }

    // 회원정보 수정 요청
    @Data
    public static class UpdateDTO{
        private String username;
        private String password;
        private String email;
        private String phone;


    }
}
