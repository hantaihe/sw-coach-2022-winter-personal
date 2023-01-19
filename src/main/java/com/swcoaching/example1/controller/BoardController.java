package com.swcoaching.example1.controller;

import com.swcoaching.example1.board.BoardService;
import com.swcoaching.example1.board.dto.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @AllArgsConstructor
@RestController
@RequestMapping
public class BoardController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final BoardService boardService;

  //@Qualifier => 하나의 interface & 여러 개의 implementation
  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/boards")
  public List<Board> getBoards() {
    List<Board> boards = boardService.findAll();
    logger.info("Boards: {}", boards);
    return boards;
  }

  @PostMapping("/boards")
  public Board createBoard(@RequestBody Board board) {
    logger.info("Board: {}", board);
    return board;
  }

  @GetMapping("/boards/{boardId}")
  public Board getBoard(@PathVariable long boardId) {
    Board board = boardService.findById(boardId);
    logger.info("Board: {}", board);
    return board;
  }
}
