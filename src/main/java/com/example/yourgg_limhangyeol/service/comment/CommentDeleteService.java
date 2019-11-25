package com.example.yourgg_limhangyeol.service.comment;

import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentDeleteService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getComment(Long commentNo) {
        return commentRepository.findById(commentNo).get();
    }

    public void commentDelete(Comment comment) {
        commentRepository.delete(comment);
    }
}
