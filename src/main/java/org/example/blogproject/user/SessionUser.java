package org.example.blogproject.user;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class SessionUser {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private Timestamp createdAt;

    @Builder
    public SessionUser(Integer id, String username, String email, String phone, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public SessionUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.createdAt = user.getCreatedAt();
    }
}
