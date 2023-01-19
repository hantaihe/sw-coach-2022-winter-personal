package com.swcoaching.example1.board;

import com.swcoaching.example1.board.dto.Board;

import java.util.List;

public interface BoardService {
  Board findById(long id);
  List<Board> findAll();
}
