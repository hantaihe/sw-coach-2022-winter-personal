package com.swcoaching.example1.board.dto;

import com.swcoaching.example1.board.Post;

import java.util.List;

public class CreateBoard {
    private final String title;
    private final String introduction;


    public CreateBoard(String title, String introduction) {
        this.title = title;
        this.introduction = introduction;
    }
}
