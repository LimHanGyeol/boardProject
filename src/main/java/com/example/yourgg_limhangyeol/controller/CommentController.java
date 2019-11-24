package com.example.yourgg_limhangyeol.controller;

import com.example.yourgg_limhangyeol.model.Board;
import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.repository.BoardRepository;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import com.example.yourgg_limhangyeol.service.comment.CommentCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentCreateService commentCreateService;

    @PostMapping("/kr/api/board/posts/{no}")
    public Comment test(String commentContent) {

        return commentCreateService.commentCreate(commentContent);
    }

//    @GetMapping("/kr/api/board/post/{no}")
//    public Board test2(@PathVariable Long no) {
//
//        return boardRepository.findById(no).get();
//    }


}
