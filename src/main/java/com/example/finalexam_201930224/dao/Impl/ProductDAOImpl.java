package com.example.finalexam_201930224.dao.Impl;

import com.example.finalexam_201930224.Repository.ProductRepository;
import com.example.finalexam_201930224.dao.ProductDAO;
import com.example.finalexam_201930224.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else throw new Exception();
        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else throw new Exception();
    }

    @Override
    public List<Product> listProductAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> listProductAllOrderByPriceDesc() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    @Override
    public List<Product> ProductByName(String name) {
        return productRepository.findAllByName(name);
    }
    @Override
    public Product selectProduct(Long number) {
        return productRepository.getReferenceById(number);
    }
}
