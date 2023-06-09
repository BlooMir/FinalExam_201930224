package com.example.finalexam_201930224.Repository;

import com.example.finalexam_201930224.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);
}