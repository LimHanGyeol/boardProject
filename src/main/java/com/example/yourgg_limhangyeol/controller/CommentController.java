package com.example.yourgg_limhangyeol.controller;

import com.example.yourgg_limhangyeol.model.Board;
import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.model.Result;
import com.example.yourgg_limhangyeol.repository.BoardRepository;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import com.example.yourgg_limhangyeol.service.comment.CommentCreateService;
import com.example.yourgg_limhangyeol.service.comment.CommentDeleteService;
import com.example.yourgg_limhangyeol.service.comment.CommentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentCreateService commentCreateService;
    @Autowired
    private CommentDeleteService commentDeleteService;
    @Autowired
    private CommentUpdateService commentUpdateService;

    // 댓글 작성
    @RequestMapping(method = RequestMethod.POST, value = "/kr/api/board/posts/{no}")
    public Comment commentCreate(String commentContent) {
        System.out.println(commentContent);
        return commentCreateService.commentCreate(commentContent);
    }

    // 댓글 수정 , produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    @RequestMapping(method = RequestMethod.PUT, value = "/kr/api/board/posts/{no}/comment/{commentNo}")
    public Comment commentUpdateForm(@PathVariable Long commentNo, String commentContentUpdate) {
        System.out.println(commentNo +" / " + commentContentUpdate);
        return commentUpdateService.commentUpdate(commentNo, commentContentUpdate);
    }


    // 댓글 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/kr/api/board/posts/{no}/comment/{commentNo}")
    public Result commentDelete(@PathVariable Long commentNo) {
        Comment comment = commentDeleteService.getComment(commentNo);
        commentDeleteService.commentDelete(comment);
        return Result.ok();
    }



}
