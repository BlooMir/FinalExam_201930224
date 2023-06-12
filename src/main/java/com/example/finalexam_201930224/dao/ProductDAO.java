package com.example.finalexam_201930224.dao;

import com.example.finalexam_201930224.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

    List<Product> listProductAll();

    List<Product> listProductAllOrderByPriceDesc();

    List<Product> ProductByName(String name);

}
