package com.example.finalexam_201930224.dto.product;

public class ChangeProductDTO {

    private Long number;
    private String name;

    public ChangeProductDTO(Long number, String name) {
        this.number = number;
        this.name = name;
    }

    public ChangeProductDTO() {}

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}