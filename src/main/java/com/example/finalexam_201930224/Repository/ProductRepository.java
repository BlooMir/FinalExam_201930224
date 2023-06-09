package com.example.finalexam_201930224.Repository;

import com.example.finalexam_201930224.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
