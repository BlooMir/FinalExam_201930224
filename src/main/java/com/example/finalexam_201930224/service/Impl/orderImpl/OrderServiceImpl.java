package com.example.finalexam_201930224.service.Impl.orderImpl;

import com.example.finalexam_201930224.dao.OrderDAO;
import com.example.finalexam_201930224.dto.order.OrderDTO;
import com.example.finalexam_201930224.dto.order.OrderResponseDTO;
import com.example.finalexam_201930224.entity.Order;
import com.example.finalexam_201930224.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderResponseDTO saveOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setProductId(orderDTO.getProductId());
        order.setProductName(orderDTO.getProductName());
        order.setUserId(orderDTO.getUserId());
        order.setUserName(orderDTO.getUserName());
        order.setPrice(orderDTO.getPrice());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDAO.insertOrder(order);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setId(saveOrder.getId());
        orderResponseDTO.setProductId(saveOrder.getProductId());
        orderResponseDTO.setProductName(saveOrder.getProductName());
        orderResponseDTO.setUserId(saveOrder.getUserId());
        orderResponseDTO.setUserName(saveOrder.getUserName());
        orderResponseDTO.setPrice(saveOrder.getPrice());

        orderDAO.minusProductStock(orderResponseDTO.getProductId());
        return orderResponseDTO;
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
