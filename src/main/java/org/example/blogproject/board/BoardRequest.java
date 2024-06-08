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
        private MultipartFile boardImg;

        public Board toEntity(User user,String backgroundImgUUID){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .category(category)
                    .boardImg(backgroundImgUUID)
                    .user(user)
                    .build();
        }
    }

    @Data
    public static class UpdateDTO{
        private String title;
        private String content;
    }
}
