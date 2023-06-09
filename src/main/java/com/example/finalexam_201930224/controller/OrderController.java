package com.example.finalexam_201930224.controller;

import com.example.finalexam_201930224.dto.order.OrderDTO;
import com.example.finalexam_201930224.dto.order.OrderResponseDTO;
import com.example.finalexam_201930224.entity.Order;
import com.example.finalexam_201930224.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderDTO orderDTO){
        OrderResponseDTO orderResponseDTO = orderService.saveOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDTO);
    }

    @GetMapping("/list")
    public List<Order> AllOrderList(){
        return orderService.AllOrderList();
    }

    @GetMapping("/listByUserId")
    public Order OrderListByUserId(Long userId) {
        return orderService.orderListByUserId(userId);
    }

    @GetMapping("/listByProductId")
    public Order OrderListByProductId(Long productId) {
        return orderService.orderListByProductId(productId);
    }

    @GetMapping("/")
    public Order OrderListByOrderId(Long orderId) {
        return orderService.orderListByOrderId(orderId);
    }
}
