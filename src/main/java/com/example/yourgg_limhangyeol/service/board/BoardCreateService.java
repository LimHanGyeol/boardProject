package com.example.yourgg_limhangyeol.service.board;

import com.example.yourgg_limhangyeol.model.Board;
import com.example.yourgg_limhangyeol.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCreateService {

    @Autowired
    private BoardRepository boardRepository;

    public Board contentCreate(String title, String content) {
        Board board = new Board(title,"null",content,"한결","20191120",1);
        boardRepository.save(board);
        return board;
    }

}
