package com.example.finalexam_201930224.dao;

import com.example.finalexam_201930224.entity.Board;

import java.util.List;

public interface BoardDAO {

    Board insertBoard(Board board);

    Board updateBoard(Long number, String title, String contents) throws Exception;

    void deleteBoard(Long number) throws Exception;

    List<Board> listBoardAll();

    List<Board> listBoardOrderByCreatedAt();

    List<Board> listBoardByUserId(String userId);

    Board selectBoard(Long boardId);
}
