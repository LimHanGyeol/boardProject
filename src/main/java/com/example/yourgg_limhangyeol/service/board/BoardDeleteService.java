package com.example.yourgg_limhangyeol.service.board;

import com.example.yourgg_limhangyeol.model.Board;
import com.example.yourgg_limhangyeol.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDeleteService {

    @Autowired
    private BoardRepository boardRepository;

    public Board getContent(Long no) {
        return boardRepository.findById(no).get();
    }

    public void contentDelete(Long no) {
        boardRepository.deleteById(no);
    }


}
