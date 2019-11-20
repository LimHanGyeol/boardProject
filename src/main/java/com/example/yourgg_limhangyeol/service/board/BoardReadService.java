package com.example.yourgg_limhangyeol.service.board;

import com.example.yourgg_limhangyeol.model.Board;
import com.example.yourgg_limhangyeol.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardReadService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }
}
