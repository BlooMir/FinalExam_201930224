package com.example.finalexam_201930224.service.user;
import com.example.finalexam_201930224.dto.user.SignInResultDTO;
import com.example.finalexam_201930224.dto.user.SignUpResultDTO;
public interface SignService {
    SignUpResultDTO signUp(String id, String password, String name, String email, String role);

    SignInResultDTO signIn(String id, String password) throws RuntimeException;
}
