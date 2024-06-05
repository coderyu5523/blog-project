package org.example.blogproject.board;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class BoardRequest {

    @Data
    public static class SaveDTO{
        private String title;
        private String content;
        private String category;
//        private MultipartFile boardImg;

        public Board toEntity(){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .category(category)
//                    .boardImg(boardImg)
                    .build();
        }
    }
}
