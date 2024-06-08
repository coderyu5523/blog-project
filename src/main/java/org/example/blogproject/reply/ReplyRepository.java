package org.example.blogproject.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Query("select r from Reply r where r.board.id = :boardId order by r.id DESC")
    Optional<List<Reply>> findByBoardId(@Param("boardId")Integer boardId);
}
