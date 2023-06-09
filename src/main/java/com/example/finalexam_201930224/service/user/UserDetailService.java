package com.example.finalexam_201930224.service.user;

import com.example.finalexam_201930224.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;

public interface UserDetailService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    List<User> listUser();
    List<User> listUserOrderByNameASC();

}
