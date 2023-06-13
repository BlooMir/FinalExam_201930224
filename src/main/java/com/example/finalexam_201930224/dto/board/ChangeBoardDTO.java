package com.example.finalexam_201930224.dto.board;

public class ChangeBoardDTO {

    private Long number;
    private String title;
    private String contents;
    private String userId;

    public ChangeBoardDTO(Long number, String title, String contents) {
        this.number = number;
        this.title = title;
        this.contents = contents;
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
