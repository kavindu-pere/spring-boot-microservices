package com.codebykavindu.bookstore.orders.domain;

import com.codebykavindu.bookstore.orders.domain.models.OrderCreatedEvent;
import com.codebykavindu.bookstore.orders.domain.models.OrderItem;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Kavindu Perera
 */
class OrderEventMapper {
    private OrderEventMapper() {}

    static OrderCreatedEvent buildOrderCreatedEvent(OrderEntity order) {
        return new OrderCreatedEvent(
                UUID.randomUUID().toString(),
                order.getOrderNumber(),
                getOrderItems(order),
                order.getCustomer(),
                order.getDeliveryAddress(),
                LocalDateTime.now());
    }

    private static Set<OrderItem> getOrderItems(OrderEntity order) {
        return order.getItems().stream()
                .map(item -> new OrderItem(item.getCode(), item.getName(), item.getPrice(), item.getQuantity()))
                .collect(Collectors.toSet());
    }
}
