package org.example.blogproject.board;

import lombok.Data;
import org.example.blogproject.user.User;

import java.sql.Timestamp;

public class BoardResponse {
    @Data
    public static class ListDTO {
        private String title;
        private String content;
    }

    @Data
    public static class DetailDTO{
        private String title;
        private String content;
        private Timestamp createdAt;
        private String category;
        private String boardImg;
        private User user;

        public DetailDTO(Board board) {
            this.title = board.getTitle();
            this.content = board.getContent();
            this.createdAt = board.getCreatedAt();
            this.category = board.getCategory();
            this.boardImg = board.getBoardImg();
            this.user = board.getUser();
        }

        @Data
        class UserDTO{
            private Integer id ;
            private String username;

            public UserDTO(UserDTO user) {
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

    }
}
