package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  public BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Board findById(long id) {
    return boardRepository.findById(id)
            .map(Board::of)
            .orElseThrow(() -> new BoardNotFoundException(id));
  }
}
