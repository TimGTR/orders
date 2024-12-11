package org.example.orders.repository;

import org.example.orders.dto.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
    Flux<Order> findByUserId(Long userId);
}
