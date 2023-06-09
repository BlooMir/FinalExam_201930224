package com.example.finalexam_201930224.Repository;

import com.example.finalexam_201930224.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
