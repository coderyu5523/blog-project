package org.example.blogproject.board;

import lombok.Data;
import org.example.blogproject._core.utils.CategoryFormat;
import org.example.blogproject._core.utils.DateFormat;
import org.example.blogproject.user.User;

import java.util.ArrayList;
import java.util.List;

public class BoardResponse {

    @Data
    public static class MainDTO {
        private List<GameDTO> gameDTOs = new ArrayList<>();
        private List<SportsDTO> sportsDTOs = new ArrayList<>();
        private List<FoodDTO> foodDTOs = new ArrayList<>();
        private List<MovieDTO> movieDTOs = new ArrayList<>();

        @Data
        public static class GameDTO {
            private int id;
            private String title;
            private String createdAt;

            public GameDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }

        @Data
        public static class SportsDTO {
            private int id;
            private String title;
            private String createdAt;

            public SportsDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }

        @Data
        public static class FoodDTO {
            private int id;
            private String title;
            private String createdAt;

            public FoodDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }

        @Data
        public static class MovieDTO {
            private int id;
            private String title;
            private String createdAt;

            public MovieDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }
    }


    @Data
    public static class SaveDTO {
        private Integer id;
        private String title;
        private String content;
        private String category;
        private User user;

        public SaveDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.category = board.getCategory();
            this.user = board.getUser();
        }
    }


    @Data
    public static class SportsListDTO {
        private Integer id;
        private String title;
        private String createdAt;
        private String username;

        public SportsListDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            this.username = board.getUser().getUsername();
        }
    }

    @Data
    public static class GameListDTO {
        private Integer id;
        private String title;
        private String createdAt;
        private String username;

        public GameListDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            this.username = board.getUser().getUsername();
        }
    }

    @Data
    public static class FoodListDTO {
        private Integer id;
        private String title;
        private String createdAt;
        private String username;

        public FoodListDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            this.username = board.getUser().getUsername();
        }
    }

    @Data
    public static class MovieListDTO {
        private Integer id;
        private String title;
        private String createdAt;
        private String username;

        public MovieListDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            this.username = board.getUser().getUsername();
        }
    }


    @Data
    public static class DetailDTO {
        private String title;
        private String content;
        private String createdAt;
        private String category;
        private String boardImg;
        private User user;
        private Boolean isBoardOwner;

        public DetailDTO(Board board, Boolean isBoardOwner) {
            this.title = board.getTitle();
            this.content = board.getContent();
            this.createdAt = DateFormat.formatTimestampWithTime(board.getCreatedAt());
            this.category = board.getCategory();
            this.boardImg = board.getBoardImg();
            this.user = board.getUser();
            this.isBoardOwner = isBoardOwner;
        }

        @Data
        class UserDTO {
            private Integer id;
            private String username;

            public UserDTO(UserDTO user) {
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

    }

    @Data
    public static class UpdateFormDTO {
        private Integer id;
        private String title;
        private String content;
        private String category;

        public UpdateFormDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.category = board.getCategory();
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer id;
        private String title;
        private String content;

        public UpdateDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
        }
    }
    @Data
    public static class DeleteDTO{
        private Integer id;
        private String formatCategory;

        public DeleteDTO(Board board) {
            this.id = board.getId();
            this.formatCategory = CategoryFormat.translateCategory(board.getCategory());
        }
    }

}
