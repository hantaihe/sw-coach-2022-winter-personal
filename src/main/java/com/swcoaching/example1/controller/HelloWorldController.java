package com.swcoaching.example1.controller;

import com.swcoaching.example1.board.Board;
import com.swcoaching.example1.board.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class HelloWorldController {

    @GetMapping("/health")
    public String getHello() {
        return "health";
    }
}
