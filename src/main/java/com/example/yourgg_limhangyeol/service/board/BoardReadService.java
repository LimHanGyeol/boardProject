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

    private Board getContentRead(Long no) {
        return boardRepository.findById(no).get();
    }

    public Board getContentPage(Long no) {
        Board content = getContentRead(no);
        content.contentHitIncrease();   // 조회수 증가
        boardRepository.save(content);
        return content;
    }
}
