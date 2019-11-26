package com.example.yourgg_limhangyeol.controller;

import com.example.yourgg_limhangyeol.dto.PostsDto;
import com.example.yourgg_limhangyeol.model.Posts;
import com.example.yourgg_limhangyeol.service.posts.PostsReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private PostsReadService postsReadService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(Model model) {
        List<PostsDto> postsList = postsReadService.getPostsList();
        model.addAttribute("postsList", postsList);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board")
    public String boardPage(Model model) {
        List<PostsDto> postsList = postsReadService.getPostsList();
        System.out.println(postsList);
        model.addAttribute("postsList", postsList);
        return "board";
    }












}
