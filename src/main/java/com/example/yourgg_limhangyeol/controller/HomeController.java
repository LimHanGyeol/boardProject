package com.example.yourgg_limhangyeol.controller;

import com.example.yourgg_limhangyeol.model.Board;
import com.example.yourgg_limhangyeol.service.board.BoardReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BoardReadService boardReadService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(Model model) {
        List<Board> boardList = boardReadService.getBoardList();
        System.out.println(boardList);
        model.addAttribute("boardList", boardList);
        return "index";
    }

}
