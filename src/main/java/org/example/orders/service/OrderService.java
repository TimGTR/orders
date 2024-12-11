package org.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.example.orders.dto.Order;
import org.example.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Mono<Order> createOrder(Order order) {
        return  orderRepository.save(order);
    }

    public Flux<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
