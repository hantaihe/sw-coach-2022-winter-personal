package com.swcoaching.example1.board;

import com.swcoaching.example1.board.dto.Board;
import com.swcoaching.example1.board.jpa.BoardEntity;
import com.swcoaching.example1.board.jpa.BoardRepository;
import com.swcoaching.example1.board.jpa.PostEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @DisplayName("게시판 정보를 조회 한다")
    @Test
    void findByIdTest() {
        // given
        BoardEntity boardEntity = mock(BoardEntity.class);
        PostEntity postEntity = mock(PostEntity.class);
        BoardRepository boardRepository = mock(BoardRepository.class);
        long testBoardId = 1L;
        String testTitle = "게시판 제목 테스트";
        String testIntroduction = "게시판 비고 테스트";
        String testPostContent = "게시판 글 내용 테스트";

        when(boardEntity.getId()).thenReturn(testBoardId);
        when(boardEntity.getTitle()).thenReturn(testTitle);
        when(boardEntity.getIntroduction()).thenReturn(testIntroduction);

        when(postEntity.getContent()).thenReturn(testPostContent);
        when(boardEntity.getPosts()).thenReturn(List.of(postEntity));

        when(boardRepository.findById(testBoardId)).thenReturn(Optional.of(boardEntity));

        // when
        BoardService boardService = new BoardServiceImpl(boardRepository);
        Board board = boardService.findById(testBoardId);

        // then
        assertEquals(board.getId(), testBoardId);
        assertEquals(board.getTitle(), testTitle);
        assertEquals(board.getIntroduction(), testIntroduction);

        assertEquals(board.getPosts().size(), 1);
        assertEquals(board.getPosts().get(0).getContent(), testPostContent);
    }
}
