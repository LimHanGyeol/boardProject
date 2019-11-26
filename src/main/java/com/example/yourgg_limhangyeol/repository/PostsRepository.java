package com.example.yourgg_limhangyeol.repository;

import com.example.yourgg_limhangyeol.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
