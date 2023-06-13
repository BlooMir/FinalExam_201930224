package com.example.finalexam_201930224.dao.Impl;

import com.example.finalexam_201930224.Repository.BoardRepository;
import com.example.finalexam_201930224.dao.BoardDAO;
import com.example.finalexam_201930224.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board insertBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Board updateBoard(Long number, String title, String contents) throws Exception{
        Optional<Board> selectBoard = boardRepository.findById(number);

        Board updateBoard;
        if(selectBoard.isPresent()) {
            Board board = selectBoard.get();
            board.setTitle(title);
            board.setContents(contents);
            board.setUpdatedAt(LocalDateTime.now());

            updateBoard = boardRepository.save(board);
        } else throw new Exception();
        return updateBoard;
    }

    @Override
    public void deleteBoard(Long number) throws Exception {
        Optional<Board> selectBoard = boardRepository.findById(number);

        if(selectBoard.isPresent()){
            Board board = selectBoard.get();
            boardRepository.delete(board);
        } else throw new Exception();
    }

    @Override
    public List<Board> listBoardAll() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> listBoardOrderByCreatedAt() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @Override
    public List<Board> listBoardByUserId(String userId) {
        return boardRepository.findBoardByUserId(userId);
    }

    @Override
    public Board selectBoard(Long boardId) {
        return boardRepository.getReferenceById(boardId);
    }
}
