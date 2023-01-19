package com.swcoaching.example1.board;

import com.swcoaching.example1.board.dto.Board;
import com.swcoaching.example1.board.jpa.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

  @Override
  public List<Board> findAll() {
    return StreamSupport.stream(boardRepository.findAll().spliterator(), false).map(Board::of).collect(Collectors.toList());
  }
}
