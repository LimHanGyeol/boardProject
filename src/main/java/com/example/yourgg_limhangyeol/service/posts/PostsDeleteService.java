package com.example.yourgg_limhangyeol.service.posts;

import com.example.yourgg_limhangyeol.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsDeleteService {

    @Autowired
    private PostsRepository postsRepository;

    public void contentDelete(Long no) {
        postsRepository.deleteById(no);
    }


}
