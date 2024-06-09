package org.example.blogproject.reply2;

import lombok.Data;
import org.example.blogproject.board.Board;
import org.example.blogproject.reply.Reply;
import org.example.blogproject.user.User;

public class Reply2Request {

    @Data
    public static class SaveDTO {
        private Integer replyId;
//        private Integer boardId;
        private String comment;

        public Reply2 toEntity(Reply reply,  User sessionUser){
            return Reply2.builder()
                    .comment(comment)
//                    .board(board)
                    .reply(reply)
                    .user(sessionUser)
                    .build();

        }
    }
}
