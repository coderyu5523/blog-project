package org.example.blogproject.board;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.blogproject.reply.Reply;
import org.example.blogproject.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String category;
    private String boardImg;
    @CreationTimestamp
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // Entity 객체의 변수명 == FK의 주인
    private List<Reply> replies = new ArrayList<>();

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

    public void update(BoardRequest.UpdateDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
    }
}
