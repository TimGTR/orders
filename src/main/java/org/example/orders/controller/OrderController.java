package org.example.orders.controller;

import lombok.RequiredArgsConstructor;
import org.example.orders.dto.Order;
import org.example.orders.dto.OrderRequest;
import org.example.orders.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public Mono<ResponseEntity<String>> createOrder(@RequestBody Order orderRequest) {
        return orderService.createOrder(orderRequest)
                .map(order -> ResponseEntity.status(HttpStatus.CREATED).body("Order created with ID: " + order.getId()))
                .onErrorReturn(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order creation failed"));
    }

    @GetMapping("/user/{userId}")
    public Flux<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }
}

