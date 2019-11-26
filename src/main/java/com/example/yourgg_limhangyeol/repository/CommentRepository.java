package com.example.yourgg_limhangyeol.repository;

import com.example.yourgg_limhangyeol.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostsNo(Long postsNo);
}
