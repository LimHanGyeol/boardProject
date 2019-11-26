package com.example.yourgg_limhangyeol.controller;

import com.example.yourgg_limhangyeol.dto.CommentDto;
import com.example.yourgg_limhangyeol.dto.PostsDto;
import com.example.yourgg_limhangyeol.model.Comment;
import com.example.yourgg_limhangyeol.model.FileUpload;
import com.example.yourgg_limhangyeol.model.Posts;
import com.example.yourgg_limhangyeol.service.posts.PostsCreateService;
import com.example.yourgg_limhangyeol.service.posts.PostsDeleteService;
import com.example.yourgg_limhangyeol.service.posts.PostsReadService;
import com.example.yourgg_limhangyeol.service.posts.PostsUpdateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PostsController {

    @Autowired
    private PostsCreateService postsCreateService;
    @Autowired
    private PostsReadService postsReadService;
    @Autowired
    private PostsUpdateService postsUpdateService;
    @Autowired
    private PostsDeleteService postsDeleteService;

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board/posts")
    public String postsCreatePage() {
        return "posts_create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/kr/board/posts")
    // @ModelAttribute("posts") Posts posts
    public String postsCreate(String title, String content, String writer, Model model) {
        Posts posts = postsCreateService.contentSave(title,content, writer);
        // 파일 업로드 작동 안함. html 깨져버림.
        //FileUpload postsCreate = postsCreateService.contentCreate(title,content,writer,posts);
        //model.addAttribute("uploadedFiles", postsCreate.getUploadFiles());
        //model.addAttribute("failedFiles",postsCreate.getFailedFiles());
        model.addAttribute("posts", posts);
        return "redirect:/kr/board";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board/posts/{no}")
    public String postsDetailPage(@PathVariable Long no, Model model) {
        Posts posts = postsReadService.getContentPage(no);
        List<CommentDto> commentToPosts = postsReadService.getCommentList(no);
        model.addAttribute("posts", posts);
        model.addAttribute("commentList", commentToPosts);
        return "posts_read";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board/posts/{no}/revision")
    public String postsUpdatePage(@PathVariable Long no, Model model) {
        Posts posts = postsReadService.getContentPage(no);
        model.addAttribute("posts", posts);
        return "posts_update";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/kr/board/posts/{no}", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postsUpdate(@PathVariable Long no, String title, String content, Model model) {
        System.out.println(title);
        Posts posts = postsUpdateService.contentUpdate(no,title,content);
        model.addAttribute("posts", posts);
        return String.format("redirect:/kr/board/posts/%d", no);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/kr/board/posts/{no}")
    public String postsDelete(@PathVariable Long no) {
        postsDeleteService.contentDelete(no);
        return "redirect:/";
    }
}
