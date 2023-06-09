package com.example.finalexam_201930224.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpResultDTO {

    private boolean succese;
    private int code;
    private String msg;
}
