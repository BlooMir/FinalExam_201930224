package com.example.finalexam_201930224.service.Impl.boardImpl;

import com.example.finalexam_201930224.dao.BoardDAO;
import com.example.finalexam_201930224.dto.board.BoardDTO;
import com.example.finalexam_201930224.dto.board.BoardResponseDTO;
import com.example.finalexam_201930224.entity.Board;
import com.example.finalexam_201930224.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class boardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public boardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public BoardResponseDTO saveBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContents(boardDTO.getContents());
        board.setUserId(boardDTO.getUserId());
        board.setUserName(boardDTO.getUserName());
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(LocalDateTime.now());

        Board saveBoard = boardDAO.insertBoard(board);

        BoardResponseDTO boardResponseDTO = new BoardResponseDTO();

        boardResponseDTO.setNumber(saveBoard.getId());
        boardResponseDTO.setTitle(saveBoard.getTitle());
        boardResponseDTO.setContents(saveBoard.getContents());
        boardResponseDTO.setUserId(saveBoard.getUserId());
        boardResponseDTO.setUserName(saveBoard.getUserName());

        return boardResponseDTO;
    }

    @Override
    public BoardResponseDTO changeBoardTitleContents(Long number, String title, String contents) throws Exception {
        Board changeBoard = boardDAO.updateBoard(number,title,contents);

        BoardResponseDTO boardResponseDTO = new BoardResponseDTO();

        boardResponseDTO.setNumber(changeBoard.getId());
        boardResponseDTO.setTitle(changeBoard.getTitle());
        boardResponseDTO.setContents(changeBoard.getTitle());
        return boardResponseDTO;
    }

    @Override
    public void deleteBoard(Long number) throws Exception {
        boardDAO.deleteBoard(number);
    }

    @Override
    public List<Board> listBoardAll() {
        return boardDAO.listBoardAll();
    }

    @Override
    public List<Board> listBoardOrderByCreateAtDesc() {
        return boardDAO.listBoardOrderByCreatedAt();
    }

    @Override
    public List<Board> listBoardByUserId(String userId) {
        return boardDAO.listBoardByUserId(userId);
    }

    @Override
    public BoardResponseDTO getBoard(Long number) {
        Board board = boardDAO.selectBoard(number);

        BoardResponseDTO boardResponseDTO = new BoardResponseDTO();
        boardResponseDTO.setNumber(board.getId());
        boardResponseDTO.setTitle(board.getTitle());
        boardResponseDTO.setContents(board.getContents());
        boardResponseDTO.setUserId(board.getUserId());
        boardResponseDTO.setUserName(board.getUserName());

        return boardResponseDTO;
    }
}
