package com.example.finalexam_201930224.service;

import com.example.finalexam_201930224.dto.board.BoardDTO;
import com.example.finalexam_201930224.dto.board.BoardResponseDTO;
import com.example.finalexam_201930224.entity.Board;

import java.util.List;

public interface BoardService {

    BoardResponseDTO saveBoard(BoardDTO boardDTO);

    BoardResponseDTO changeBoardTitleContents(Long number, String title, String contents) throws Exception;

    void deleteBoard(Long number) throws Exception;

    List<Board> listBoardAll();

    List<Board> listBoardOrderByCreateAtDesc();

    List<Board> listBoardByUserId(String userId);

    BoardResponseDTO getBoard(Long number);
}
