package com.example.yourgg_limhangyeol.service.comment;

import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentCreateService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment commentCreate(String commentContent) {
        Comment comment = new Comment(4, commentContent, "191124","tommy");
        return commentRepository.save(comment);
    }

}
