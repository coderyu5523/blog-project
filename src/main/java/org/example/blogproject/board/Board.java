package org.example.blogproject.board;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.blogproject.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String title;
    private String content;
    private String category;
    private String boardImg;
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @Builder
    public Board(Integer id, String title, String content, String category, String boardImg, Timestamp createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.boardImg = boardImg;
        this.createdAt = createdAt;
        this.user = user;
    }
}
