package org.example.orders.service;

import org.example.orders.dto.Order;
import org.example.orders.dto.OrderRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    public Mono<Order> createOrder(OrderRequest orderRequest) {
        return null;
    }

    public Flux<Order> getOrdersByUser(String userId) {
        return null;
    }
}
