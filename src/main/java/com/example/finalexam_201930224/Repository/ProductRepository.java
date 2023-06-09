package com.example.finalexam_201930224.Repository;

import com.example.finalexam_201930224.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);
}
