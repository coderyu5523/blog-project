package org.example.blogproject.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query("select b from Board b ORDER BY b.id DESC")
    List<Board> findAll();

    @Query("select b from Board b join fetch b.user where b.id = :boardId")
    Optional<Board> findByIdWithUser(@Param("boardId") Integer boardId);

    @Query("select b from Board b join fetch b.user where b.category = '스포츠' ORDER BY b.id DESC")
    Optional<List<Board>> findBySprots();

    @Query("select b from Board b join fetch b.user where b.category = '게임' ORDER BY b.id DESC")
    Optional<List<Board>> findByGame();

    @Query("select b from Board b join fetch b.user where b.category = '음식' ORDER BY b.id DESC")
    Optional<List<Board>> findByFood();

    @Query("select b from Board b join fetch b.user where b.category = '영화' ORDER BY b.id DESC")
    Optional<List<Board>> findByMovie();

    @Query("select b from Board b join fetch b.user where b.user.id = :id order by b.id DESC")
    Optional<List<Board>> findByUserId(@Param("id") Integer id);

}
