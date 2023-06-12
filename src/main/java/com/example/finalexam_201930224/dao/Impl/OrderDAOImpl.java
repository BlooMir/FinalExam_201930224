package com.example.finalexam_201930224.dao.Impl;

import com.example.finalexam_201930224.Repository.OrderRepository;
import com.example.finalexam_201930224.Repository.ProductRepository;
import com.example.finalexam_201930224.dao.OrderDAO;
import com.example.finalexam_201930224.entity.Order;
import com.example.finalexam_201930224.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderDAOImpl(OrderRepository orderRepository , ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order insertOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Product productByProductName(Long productId) {
        return productRepository.getReferenceById(productId);
    }

//    @Override
//    public long minusProductStock(long productId) {
//        Product product = productRepository.findByNumber(productId);
//        int minusProductStock = product.getStock() - 1;
//        product.setStock(minusProductStock);
//    }

    @Override
    public List<Order> AllOrderList() {
        return orderRepository.findAll();
    }



    @Override
    public Order orderListByUserId(Long userId) {
        return orderRepository.getReferenceById(userId);
    }

    @Override
    public Order orderListByProductId(Long productId) {
        return orderRepository.getReferenceById(productId);
    }

    @Override
    public Order orderListByOrderId(Long orderId) {
        return orderRepository.getReferenceById(orderId);
    }
}
