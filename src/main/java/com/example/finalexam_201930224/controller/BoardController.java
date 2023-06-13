package com.example.finalexam_201930224.controller;

import com.example.finalexam_201930224.dto.board.BoardDTO;
import com.example.finalexam_201930224.dto.board.BoardResponseDTO;
import com.example.finalexam_201930224.dto.board.ChangeBoardDTO;
import com.example.finalexam_201930224.entity.Board;
import com.example.finalexam_201930224.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<BoardResponseDTO> createBoard(@RequestBody BoardDTO boardDTO){
        BoardResponseDTO boardResponseDTO = boardService.saveBoard(boardDTO);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDTO);
    }

    @PutMapping
    public ResponseEntity<BoardResponseDTO> changeBoard(Principal principal, @RequestBody ChangeBoardDTO changeBoardDTO) throws Exception{
        if(Objects.equals(changeBoardDTO.getUserId(), principal.getName())){
            BoardResponseDTO boardResponseDTO = boardService.changeBoardTitleContents(changeBoardDTO.getNumber(), changeBoardDTO.getTitle(), changeBoardDTO.getContents());
            return ResponseEntity.status(HttpStatus.OK).body(boardResponseDTO);
        }
        else {
            throw new Exception("수정 권한이 없는 글입니다.");
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBoard(Principal principal, Long number, String userId) throws Exception {
        if(Objects.equals(userId, principal.getName())){
            boardService.deleteBoard(number);
            return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 되었습니다.");
        }
        else {
            throw new Exception("삭제 권한이 없는 글입니다.");
        }


    }

    @GetMapping("/list")
    public List<Board> listBoardAll(){
        return boardService.listBoardAll();
    }

    @GetMapping("/listOrderBycreateAt")
    public List<Board> listBoardOrderByCreateAtDesc(){
        return boardService.listBoardOrderByCreateAtDesc();
    }

    @GetMapping("/byUserId")
    public List<Board> listBoardByUserId(String userId){
        return boardService.listBoardByUserId(userId);
    }

    @GetMapping("/")
    public ResponseEntity<BoardResponseDTO> getBoard(Long number) {
        BoardResponseDTO boardResponseDTO = boardService.getBoard(number);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDTO);
    }
}
