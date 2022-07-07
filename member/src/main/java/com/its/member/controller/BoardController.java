package com.its.member.controller;

import com.its.member.dto.BoardDTO;
import com.its.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService bs;

    @GetMapping("/save-form")
    public String saveForm() {
        return "board/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        bs.save(boardDTO);
        return "redirect:/board";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("boardList", bs.findAll());
        return "board/list";
    }

    @GetMapping("/{boardId}")
    public String findById(@PathVariable Long boardId, Model model) {
        model.addAttribute("board", bs.findById(boardId));
        return "board/detail";
    }
}
