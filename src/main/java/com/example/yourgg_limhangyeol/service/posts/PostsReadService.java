package com.example.yourgg_limhangyeol.service.posts;

import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.model.Posts;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import com.example.yourgg_limhangyeol.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsReadService {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<Posts> getBoardList() {
        return postsRepository.findAll();
    }
    public List<Comment> getCommentList(Long postsNo) {
        return commentRepository.findByPostsNo(postsNo);
    }

    private Posts getContentRead(Long no) {
        return postsRepository.findById(no).get();
    }

    public Posts getContentPage(Long no) {
        Posts content = getContentRead(no);
        content.contentHitIncrease();   // 조회수 증가
        postsRepository.save(content);
        return content;
    }
}
