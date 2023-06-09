package com.example.finalexam_201930224.dto.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignInResultDTO extends SignUpResultDTO{

    private String token;

    @Builder
    public SignInResultDTO(boolean succese, int code, String msg, String token) {
        super(succese, code, msg);
        this.token = token;
    }


}
