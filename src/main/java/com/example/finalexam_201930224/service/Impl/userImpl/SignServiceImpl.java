package com.example.finalexam_201930224.service.Impl.userImpl;

import com.example.finalexam_201930224.Repository.UserRepository;
import com.example.finalexam_201930224.dto.user.CommonResponse;
import com.example.finalexam_201930224.dto.user.SignInResultDTO;
import com.example.finalexam_201930224.dto.user.SignUpResultDTO;
import com.example.finalexam_201930224.config.security.jwt.JwtTokenProvider;
import com.example.finalexam_201930224.entity.User;
import com.example.finalexam_201930224.service.user.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignServiceImpl implements SignService {

    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public SignServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SignUpResultDTO signUp(String id, String password, String name, String email, String role) {
        System.out.println("[signUp]");
        User user;
        if(role.equalsIgnoreCase("admin")){
            user = User.builder()
                    .uid(id)
                    .name(name)
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_ADMIN")).build();
        } else {
            user = User.builder()
                    .uid(id)
                    .name(name)
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_USER")).build();
        }
        User savedUser = userRepository.save(user);
        SignUpResultDTO signUpResultDTO = new SignUpResultDTO();
        if(!savedUser.getName().isEmpty()){
            setSuccessResult(signUpResultDTO);
        } else {
            setFailResult(signUpResultDTO);
        }
        return signUpResultDTO;
    }

    @Override
    public SignInResultDTO signIn(String id, String password) throws RuntimeException {
        User user = userRepository.getByUid(id);
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException();
        }
        SignInResultDTO signInResultDTO = SignInResultDTO.builder()
                .token(jwtTokenProvider.createToken(
                        String.valueOf(user.getUid()), user.getRoles(), user.getName())).build();
        setSuccessResult(signInResultDTO);

        return signInResultDTO;
    }

    private void setSuccessResult(SignUpResultDTO signUpResultDTO){
        signUpResultDTO.setSuccese(true);
        signUpResultDTO.setCode(CommonResponse.SUCCESS.getCode());
        signUpResultDTO.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(SignUpResultDTO signUpResultDTO){
        signUpResultDTO.setSuccese(false);
        signUpResultDTO.setCode(CommonResponse.FAIL.getCode());
        signUpResultDTO.setMsg(CommonResponse.FAIL.getMsg());
    }
}
