package com.example.finalexam_201930224.dao;

import com.example.finalexam_201930224.entity.Order;
import com.example.finalexam_201930224.entity.Product;

import java.util.List;

public interface OrderDAO {
    Order insertOrder(Order order);

    void minusProductStock(Long productId);

    List<Order> AllOrderList();

    Product productByProductName(Long productId);

    Order orderListByUserId(Long userId);

    Order orderListByProductId(Long productId);

    Order orderListByOrderId(Long orderId);
}
