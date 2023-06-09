package com.example.finalexam_201930224.controller;

import com.example.finalexam_201930224.dto.user.SignInResultDTO;
import com.example.finalexam_201930224.dto.user.SignUpResultDTO;
import com.example.finalexam_201930224.service.user.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-api")
public class SignController {

    private final SignService signService;

    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping("/sign-up")
    public SignUpResultDTO signUP(
            @RequestParam String id,
            @RequestParam String password,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String role
    ) throws RuntimeException {
        return signService.signUp(id, password, name, email, role);
    }

    @PostMapping("/sign-in")
    public SignInResultDTO signIn(@RequestParam String id, @RequestParam String password) throws RuntimeException {
        SignInResultDTO signInResultDTO = signService.signIn(id, password);
        if(signInResultDTO.getCode() == 0) {
            System.out.println("[정상 로그인]" + signInResultDTO.getToken());
        }
        return signInResultDTO;
    }

    @GetMapping("/exception")
    public void exception() throws RuntimeException {
        throw new RuntimeException("접근이 금지되었습니다.");
    }

}
