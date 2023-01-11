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
  // Transactional: 조회 하나할 때 connection 하나 => 조회 여러개면 connect 여러개 => 이걸 하나의 connect으로 만들기 위해 사용
  // readOnly = true: 읽기용 DB(read replica)에 요청을 하기 위해
  public Board findById(long id) {
    return boardRepository.findById(id)
            .map(Board::of)
            .orElseThrow(() -> new BoardNotFoundException(id));
  }
}
