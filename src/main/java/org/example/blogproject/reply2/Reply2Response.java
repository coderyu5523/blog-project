package org.example.blogproject.reply2;

import lombok.Data;
import org.example.blogproject.reply.Reply;
import org.example.blogproject.user.User;

public class Reply2Response {

    @Data
    public static class SaveDTO {
        private Integer id;
        private String comment;
        private User user;
        private Reply reply;
        private Integer boardId;

        public SaveDTO(Reply2 reply2) {
            this.id = reply2.getId();
            this.comment = reply2.getComment();
            this.user = reply2.getUser();
            this.reply = reply2.getReply();
            this.boardId = reply2.getReply().getBoard().getId();
        }
    }
}
