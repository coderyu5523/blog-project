package org.example.blogproject.user;

import lombok.Data;

public class UserRequest {

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
    @Data
    public static class LoginDTO{
        private String username;
        private String password;
    }
}
