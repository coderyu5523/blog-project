package org.example.blogproject.reply;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.blogproject.board.Board;
import org.example.blogproject.reply2.Reply2;
import org.example.blogproject.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "reply_tb")
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;
    @CreationTimestamp
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @OneToMany(mappedBy = "reply", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // Entity 객체의 변수명 == FK의 주인
    private List<Reply2> replies2 = new ArrayList<>();

    @Builder
    public Reply(Integer id, String comment, Timestamp createdAt, User user, Board board) {
        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
        this.user = user;
        this.board = board;
    }
}
