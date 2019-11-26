package com.example.yourgg_limhangyeol.service.posts;

import com.example.yourgg_limhangyeol.model.Posts;
import com.example.yourgg_limhangyeol.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsCreateService {

    @Autowired
    private PostsRepository postsRepository;

    public Posts contentCreate(String title, String content) {
        Posts posts = new Posts(title,"null",content,"한결",1);
        return postsRepository.save(posts);
    }

}
