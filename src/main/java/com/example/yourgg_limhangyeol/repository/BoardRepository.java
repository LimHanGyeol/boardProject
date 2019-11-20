package com.example.yourgg_limhangyeol.repository;

import com.example.yourgg_limhangyeol.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
