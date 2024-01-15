package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserUserId(userId);
    }

    public List<Order> getOrdersByProductId(Long productId) {
        return orderRepository.findByOrderItemsProductProductId(productId);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
}
