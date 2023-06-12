package com.example.finalexam_201930224.service.Impl.orderImpl;

import com.example.finalexam_201930224.dao.OrderDAO;
import com.example.finalexam_201930224.dto.order.OrderDTO;
import com.example.finalexam_201930224.dto.order.OrderResponseDTO;
import com.example.finalexam_201930224.dto.product.ProductResponseDTO;
import com.example.finalexam_201930224.entity.Order;
import com.example.finalexam_201930224.entity.Product;
import com.example.finalexam_201930224.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderResponseDTO saveOrder(OrderResponseDTO orderResponseDTO) {
        Order order = new Order();
        order.setProductId(orderResponseDTO.getProductId());
        order.setProductName(orderResponseDTO.getProductName());
        order.setUserId(orderResponseDTO.getUserId());
        order.setUserName(orderResponseDTO.getUserName());
        order.setPrice(orderResponseDTO.getPrice());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDAO.insertOrder(order);

        OrderResponseDTO newOrderResponseDTO = new OrderResponseDTO();

        newOrderResponseDTO.setId(saveOrder.getId());
        newOrderResponseDTO.setProductId(saveOrder.getProductId());
        newOrderResponseDTO.setProductName(saveOrder.getProductName());
        newOrderResponseDTO.setUserId(saveOrder.getUserId());
        newOrderResponseDTO.setUserName(saveOrder.getUserName());
        newOrderResponseDTO.setPrice(saveOrder.getPrice());

        return newOrderResponseDTO;
    }

    @Override
    public ProductResponseDTO productByProductName(Long productId) {

        Product product = orderDAO.productByProductName(productId);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setNumber(product.getNumber());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStock(product.getStock());

        return productResponseDTO;
    }

    @Override
    public List<Order> AllOrderList() {
        return orderDAO.AllOrderList();
    }

    @Override
    public Order orderListByUserId(Long userId) {
        return orderDAO.orderListByUserId(userId);
    }

    @Override
    public Order orderListByProductId(Long productId) {
        return orderDAO.orderListByProductId(productId);
    }

    @Override
    public Order orderListByOrderId(Long orderId) {
        return orderDAO.orderListByOrderId(orderId);
    }

}
