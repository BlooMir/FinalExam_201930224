package com.example.finalexam_201930224.Repository;

import com.example.finalexam_201930224.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
