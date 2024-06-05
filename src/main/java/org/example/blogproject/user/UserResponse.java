package org.example.blogproject.user;



import lombok.Data;

import java.sql.Timestamp;

public class UserResponse {
    @Data
    public static class JoinDTO{
        private Integer id;
        private String username;
        private String email;
        private String phone;

        public JoinDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.phone = user.getPhone();
        }
    }

    @Data
    public static class LoginDTO{
        private Integer id ;
        private String username;

        public LoginDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }
    @Data
    public static class UserInfoDTO{
        private Integer id;
        private String username;;
        private String email;
        private String phone;
        public Timestamp createdAt;

        public UserInfoDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.phone = user.getPhone();
            this.createdAt = user.getCreatedAt();
        }
    }



}
