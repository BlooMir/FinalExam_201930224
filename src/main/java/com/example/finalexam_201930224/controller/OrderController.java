package com.example.finalexam_201930224.controller;

import com.example.finalexam_201930224.dto.order.OrderDTO;
import com.example.finalexam_201930224.dto.order.OrderResponseDTO;
import com.example.finalexam_201930224.dto.product.ProductDTO;
import com.example.finalexam_201930224.dto.product.ProductResponseDTO;
import com.example.finalexam_201930224.entity.Order;
import com.example.finalexam_201930224.entity.Product;
import com.example.finalexam_201930224.entity.User;
import com.example.finalexam_201930224.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public ResponseEntity<OrderResponseDTO> createOrder(Principal principal, Long productId, String userName) throws Exception{

        ProductResponseDTO productResponseDTO = orderService.productByProductName(productId);
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        if(productResponseDTO.getStock() <= 0){
            throw new Exception("재고 부족");
        }
        else {
            orderService.minusProductStock(productId);

            orderResponseDTO.setProductId(productResponseDTO.getNumber());
            orderResponseDTO.setProductName(productResponseDTO.getName());
            orderResponseDTO.setUserId(principal.getName());
            orderResponseDTO.setUserName(userName);
            orderResponseDTO.setPrice(productResponseDTO.getPrice());

            OrderResponseDTO newOrderResponseDTO = orderService.saveOrder(orderResponseDTO);

            return ResponseEntity.status(HttpStatus.OK).body(newOrderResponseDTO);
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Order> AllOrderList(){
        return orderService.AllOrderList();
    }

    @GetMapping("/listByUserId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Order OrderListByUserId(Long userId) {
        return orderService.orderListByUserId(userId);
    }

    @GetMapping("/listByProductId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Order OrderListByProductId(Long productId) {
        return orderService.orderListByProductId(productId);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Order OrderListByOrderId(Long orderId) {
        return orderService.orderListByOrderId(orderId);
    }
}
