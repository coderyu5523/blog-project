package org.example.blogproject.board;

import lombok.Data;
import org.example.blogproject.user.User;
import org.springframework.web.multipart.MultipartFile;

public class BoardRequest {

    //게시글 작성 요청
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

    // 게시글 수정 요청
    @Data
    public static class UpdateDTO{
        private String title;
        private String content;
    }
}
