package org.example.blogproject.reply;

import lombok.Data;

public class ReplyResponse {

    // 댓글 저장
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

    // 댓글 삭제
    @Data
    public static class DeleteDTO{
        private Integer id;
        private Integer boardId;

        public DeleteDTO(Reply reply) {
            this.id = reply.getId();
            this.boardId = reply.getBoard().getId();
        }
    }
}
