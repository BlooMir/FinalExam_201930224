package com.example.finalexam_201930224.service.Impl.userImpl;

import com.example.finalexam_201930224.Repository.UserRepository;
import com.example.finalexam_201930224.entity.User;
import com.example.finalexam_201930224.service.user.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByUid(username);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> listUserOrderByNameASC() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
