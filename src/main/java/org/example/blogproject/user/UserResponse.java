package org.example.blogproject.user;

import lombok.Data;
import org.example.blogproject._core.utils.CategoryFormat;
import org.example.blogproject._core.utils.DateFormat;
import org.example.blogproject.board.Board;
import org.example.blogproject.board.BoardResponse;
import org.example.blogproject.reply.Reply;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserResponse {
    // 회원가입 응답
    @Data
    public static class JoinDTO {
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

    // 로그인 응답
    @Data
    public static class LoginDTO {
        private Integer id;
        private String username;

        public LoginDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }

    // 마이페이지
    @Data
    public static class UserInfoDTO {
        private Integer id;
        private String username;
        ;
        private String email;
        private String phone;
        private Timestamp createdAt;
        private List<BoardDTO> boards = new ArrayList<>();
        private List<ReplyDTO> replies = new ArrayList<>();

        public UserInfoDTO(User user, List<Board> boardList, List<Reply> replyList) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.phone = user.getPhone();
            this.createdAt = user.getCreatedAt();
            this.boards = boardList.stream().map(board -> new BoardDTO(board)).toList();
            this.replies = replyList.stream().map(reply -> new ReplyDTO(reply)).toList();
        }

        @Data
        public class BoardDTO {
            private Integer id;
            private String title;
            private String category;
            private String categoryFormat;
            private String createdAt;

            public BoardDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.category = board.getCategory();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
                this.categoryFormat = CategoryFormat.translateCategory(board.getCategory());
            }
        }

        @Data
        public static class ReplyDTO {
            private Integer id;
            private String comment;
            private String createdAt;
            public Integer boardId;

            public ReplyDTO(Reply reply) {
                this.id = reply.getId();
                this.comment = reply.getComment();
                this.createdAt = DateFormat.formatTimestamp(reply.getCreatedAt());
                this.boardId = reply.getBoard().getId();
            }
        }
    }

    // 회원정보 수정 페이지
    @Data
    public static class UpdateFormDTO {
        private Integer id;
        private String username;
        private String email;
        private String phone;

        public UpdateFormDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.phone = user.getPhone();
        }
    }

    // 회원정보 수정 응답
    @Data
    public static class UpdateDTO {
        private Integer id;
        private String username;
        private String email;
        private String phone;
        private Timestamp createdAt;

        public UpdateDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.phone = user.getPhone();
            this.createdAt = user.getCreatedAt();
        }
    }

}
