package com.example.yourgg_limhangyeol.service.comment;

import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.model.Posts;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import com.example.yourgg_limhangyeol.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentCreateService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostsRepository postsRepository;

    public Posts getPosts(Long postsNo) {
        return postsRepository.findById(postsNo).get();
    }

    public Comment commentCreate(Posts posts, String commentContent, String commentWriter) {
        Comment comment = new Comment(posts, commentContent,commentWriter);
        return commentRepository.save(comment);
    }

}
