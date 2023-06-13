package com.example.finalexam_201930224.service;

import com.example.finalexam_201930224.dto.order.OrderDTO;
import com.example.finalexam_201930224.dto.order.OrderResponseDTO;
import com.example.finalexam_201930224.dto.product.ProductDTO;
import com.example.finalexam_201930224.dto.product.ProductResponseDTO;
import com.example.finalexam_201930224.entity.Order;
import com.example.finalexam_201930224.entity.Product;

import java.util.List;

public interface OrderService {
    OrderResponseDTO saveOrder(OrderResponseDTO orderResponseDTO);

    ProductResponseDTO productByProductName(Long productId);

    void minusProductStock(Long productID);

    List<Order> AllOrderList();

    Order orderListByUserId(Long userId);

    Order orderListByProductId(Long productId);

    Order orderListByOrderId(Long orderId);
}
