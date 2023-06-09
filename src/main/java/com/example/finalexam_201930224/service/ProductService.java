package com.example.finalexam_201930224.service;

import com.example.finalexam_201930224.dto.product.ProductDTO;
import com.example.finalexam_201930224.dto.product.ProductResponseDTO;
import com.example.finalexam_201930224.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDTO saveProduct(ProductDTO productDto);

    ProductResponseDTO changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

    List<Product> listProductAll();

    List<Product> listProductAllOrderByPriceDesc();

    List<Product> listProductFindByName(String name);

    ProductResponseDTO getProduct(Long number);
}
