package org.example.blogproject.reply;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.blogproject.board.Board;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Table(name = "reply_tb")
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @CreationTimestamp
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    public Reply(Integer id, String content, Timestamp createdAt, Board board) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.board = board;
    }
}
