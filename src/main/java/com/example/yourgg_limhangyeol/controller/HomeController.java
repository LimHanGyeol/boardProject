package com.example.yourgg_limhangyeol.controller;

import com.example.yourgg_limhangyeol.model.Board;
import com.example.yourgg_limhangyeol.service.board.BoardCreateService;
import com.example.yourgg_limhangyeol.service.board.BoardDeleteService;
import com.example.yourgg_limhangyeol.service.board.BoardReadService;
import com.example.yourgg_limhangyeol.service.board.BoardUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BoardReadService boardReadService;
    @Autowired
    private BoardCreateService boardCreateService;
    @Autowired
    private BoardDeleteService boardDeleteService;
    @Autowired
    private BoardUpdateService boardUpdateService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(Model model) {
        List<Board> boardList = boardReadService.getBoardList();
        System.out.println(boardList);
        model.addAttribute("boardList", boardList);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board")
    public String boardPage(Model model) {
        List<Board> boardList = boardReadService.getBoardList();
        System.out.println(boardList);
        model.addAttribute("boardList", boardList);
        return "board";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board/posts")
    public String contentCreatePage() {
        return "posts_create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/kr/board/posts")
    public String contentCreate(String title, String content, Model model) {
        System.out.println(title);
        Board board = boardCreateService.contentCreate(title,content);
        model.addAttribute("board", board);
        return "redirect:/kr/board";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board/posts/{no}")
    public String contentPage(@PathVariable Long no, Model model) {
        Board board = boardReadService.getContentPage(no);
        model.addAttribute("board",board);
        return "posts_read";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/kr/board/posts/{no}/revision")
    public String contentUpdatePage(@PathVariable Long no, Model model) {
        Board board = boardReadService.getContentPage(no);
        model.addAttribute("board",board);
        return "content_update";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/kr/board/posts/{no}", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String contentUpdate(@PathVariable Long no, String title, String content, Model model) {
        System.out.println(title);
        //Board board = boardUpdateService.getContent(no);
        Board board = boardUpdateService.contentUpdate(no,title,content);
        model.addAttribute("board",board);
        return String.format("redirect:/kr/board/posts/%d", no);
                //String.format("redirect:/kr/board/posts/%d", no);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/kr/board/posts/{no}")
    public String contentDelete(@PathVariable Long no) {
        //Board content = boardDeleteService.getContent(no);
        boardDeleteService.contentDelete(no);
        return "redirect:/";
    }
}
