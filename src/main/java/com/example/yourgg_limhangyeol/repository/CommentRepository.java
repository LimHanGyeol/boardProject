package com.example.yourgg_limhangyeol.repository;

import com.example.yourgg_limhangyeol.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
