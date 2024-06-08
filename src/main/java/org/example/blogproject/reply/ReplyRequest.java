package org.example.blogproject.reply;

import lombok.Data;
import org.example.blogproject.board.Board;
import org.example.blogproject.user.SessionUser;
import org.example.blogproject.user.User;

public class ReplyRequest {

    // 댓글 저장
    @Data
    public static class SaveDTO {
        private Integer boardId;
        private String comment;

        public Reply toEntity(Board board, User sessionUser) {
            return Reply.builder()
                    .comment(comment)
                    .board(board)
                    .user(sessionUser)
                    .build();

        }
    }
}
