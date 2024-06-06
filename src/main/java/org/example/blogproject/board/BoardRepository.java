package org.example.blogproject.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query("select b from Board b join fetch b.user where b.id = :boardId")
    Optional<Board> findByIdWithUser(@Param("boardId") Integer boardId);
    @Query("select b from Board b join fetch b.user where b.category = '스포츠'")
    Optional<List<Board>> findBySprots();

}
