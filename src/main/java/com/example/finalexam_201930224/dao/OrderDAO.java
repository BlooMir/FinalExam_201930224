package com.example.finalexam_201930224.dao;

import com.example.finalexam_201930224.entity.Order;

import java.util.List;

public interface OrderDAO {
    Order insertOrder(Order order);
    void minusProductStock(long productId);

    List<Order> AllOrderList();

    Order orderListByUserId(Long userId);

    Order orderListByProductId(Long productId);

    Order orderListByOrderId(Long orderId);
}
