package org.example.blogproject.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("select b from Board b join fetch b.user where b.category = '스포츠'")
    Optional<Page<Board>> findBySprots(Pageable pageable);

    @Query("select b from Board b join fetch b.user where b.category = '게임'")
    Optional<Page<Board>> findByGame(Pageable pageable);

    @Query("select b from Board b join fetch b.user where b.category = '음식'")
    Optional<Page<Board>> findByFood(Pageable pageable);

    @Query("select b from Board b join fetch b.user where b.category = '영화'")
    Optional<Page<Board>> findByMovie(Pageable pageable);

    @Query("select b from Board b join fetch b.user where b.user.id = :id order by b.id DESC")
    Optional<List<Board>> findByUserId(@Param("id") Integer id);

    @Query("select b from Board b join fetch b.user where b.title like %:keyword% or b.content like %:keyword% or b.user.username like %:keyword%")
    Optional<Page<Board>> findByKeyword(@Param("keyword") String keyword,Pageable pageable);

    @Query("select count(b) from Board b join b.user u where b.title like %:keyword% or b.content like %:keyword% or u.username like %:keyword%")
    Long findWithCount(@Param("keyword") String keyword);

    @Query("select b from Board b join fetch b.user where b.category ='스포츠' and (b.title like %:keyword% or b.content like %:keyword% or b.user.username like %:keyword%)")
    Optional<Page<Board>> findBySprotsWithKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("select b from Board b join fetch b.user where b.category ='게임' and (b.title like %:keyword% or b.content like %:keyword% or b.user.username like %:keyword%)")
    Optional<Page<Board>> findByGameWithKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("select b from Board b join fetch b.user where b.category ='영화' and (b.title like %:keyword% or b.content like %:keyword% or b.user.username like %:keyword%)")
    Optional<Page<Board>> findByMovieWithKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("select b from Board b join fetch b.user where b.category ='음식' and (b.title like %:keyword% or b.content like %:keyword% or b.user.username like %:keyword%)")
    Optional<Page<Board>> findByFoodWithKeyword(@Param("keyword") String keyword, Pageable pageable);
}
