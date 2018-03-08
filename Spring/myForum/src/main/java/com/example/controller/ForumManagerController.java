package com.example.controller;

import com.example.domain.Board;
import com.example.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ForumManagerController extends BaseController {
    private ForumService forumService;

    @Autowired
    public void setForumService(ForumService forumService) {
        this.forumService = forumService;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String listAllBoard(Model model) {

        List<Board> boards = forumService.getAllBoard();
        model.addAttribute("boards", boards);
        return "listAllBoards";
    }
}
