package com.example.finalexam_201930224.service;

import com.example.finalexam_201930224.dto.order.OrderDTO;
import com.example.finalexam_201930224.dto.order.OrderResponseDTO;
import com.example.finalexam_201930224.entity.Order;

import java.util.List;

public interface OrderService {
    OrderResponseDTO saveOrder(OrderDTO orderDTO);

    List<Order> AllOrderList();

    Order orderListByUserId(Long userId);

    Order orderListByProductId(Long productId);

    Order orderListByOrderId(Long orderId);
}
