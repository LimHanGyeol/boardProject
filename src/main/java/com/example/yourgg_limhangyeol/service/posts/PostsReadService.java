package com.example.yourgg_limhangyeol.service.posts;

import com.example.yourgg_limhangyeol.dto.CommentDto;
import com.example.yourgg_limhangyeol.dto.PostsDto;
import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.model.Posts;
import com.example.yourgg_limhangyeol.repository.CommentRepository;
import com.example.yourgg_limhangyeol.repository.PostsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsReadService {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<PostsDto> getPostsList() {
        List<Posts> postsList = postsRepository.findAll();
        return postsList.stream().map(posts -> modelMapper.map(posts, PostsDto.class))
                .collect(Collectors.toList());
    }


    public List<CommentDto> getCommentList(Long postsNo) {
        List<Comment> commentList = commentRepository.findByPostsNo(postsNo);
        return commentList.stream().map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
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
