package com.example.myboard.controller;

import com.example.myboard.domain.Board;
import com.example.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    BoardService service;

    @GetMapping
    public String boards(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                                                                  ModelMap modelMap) {
        Page<Board> boardPage = service.getBoards(page);
        modelMap.addAttribute("list",boardPage);

        return "list";
    }
}
