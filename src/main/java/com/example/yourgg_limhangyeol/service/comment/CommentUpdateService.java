package com.example.yourgg_limhangyeol.service.comment;

import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentUpdateService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getComment(Long commentNo) {
        return commentRepository.findById(commentNo).get();
    }

    public Comment commentUpdate(Long commentNo, String commentContent) {
        Comment comment = getComment(commentNo);
        comment.commentUpdate(commentContent);

        return commentRepository.save(comment);
    }

}
