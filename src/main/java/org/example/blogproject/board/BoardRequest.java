package org.example.blogproject.board;

import lombok.Data;
import org.example.blogproject.user.SessionUser;
import org.example.blogproject.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;

public class BoardRequest {

    @Data
    public static class SaveDTO{
        private String title;
        private String content;
        private String category;
        private User user;
//        private MultipartFile boardImg;

        public Board toEntity(User user){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .category(category)
//                    .boardImg(boardImg)
                    .user(user)
                    .build();
        }
    }
}