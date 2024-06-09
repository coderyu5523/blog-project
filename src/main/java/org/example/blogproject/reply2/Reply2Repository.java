package org.example.blogproject.reply2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Reply2Repository extends JpaRepository<Reply2, Integer> {
    @Query("select r from Reply2 r where r.reply.id = :id")
    Optional<List<Reply2>> findByReplyId(@Param("id")Integer id);
}
