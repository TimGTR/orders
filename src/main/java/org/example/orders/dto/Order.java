package org.example.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id; // MongoDB использует String ID по умолчанию
    private Long userId; // ID пользователя, который сделал заказ
    private String productName;
    private Integer quantity;
    private Double price; // Можно добавить дополнительные поля
}
