package org.example.orders.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orders.dto.Order;
import org.example.orders.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
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
    public Flux<Order> getOrdersByUserId(@PathVariable Long userId) throws InterruptedException {
        log.info("Get orders by userId: {}", userId);
        return
                Flux.interval(Duration.ofSeconds(1)) // Каждую секунду
                        .map(i -> new Order(i.toString(), userId, "Item " + i, 1, 10.0 + i))
                        .take(5);

//                Mono.delay(Duration.ofSeconds(5))
//                .flatMapMany(ignore -> Flux.just(new Order("0", 0L, "пк", 1, 1.0)));
    }
}

