package com.example.finalexam_201930224.dto.board;

public class BoardResponseDTO {

    private Long number;
    private String title;
    private String contents;
    private String userId;
    private String userName;

    public BoardResponseDTO() {}

    public BoardResponseDTO(Long number, String title, String contents, String userId, String userName) {
        this.number = number;
        this.title = title;
        this.contents = contents;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
