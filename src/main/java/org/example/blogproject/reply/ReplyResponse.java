package org.example.blogproject.reply;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

public class ReplyResponse {

    @Data
    public static class SaveDTO {
        private Integer id;
        private String comment;
        private Integer userId;
        private Integer boardId;

        public SaveDTO(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.userId = reply.getUser().getId();
            this.boardId = reply.getBoard().getId();
        }
    }
}
