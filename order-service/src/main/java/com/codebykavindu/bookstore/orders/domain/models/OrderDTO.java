package com.codebykavindu.bookstore.orders.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Kavindu Perera
 */
public record OrderDTO(
        String orderNumber,
        String userName,
        Set<OrderItem> orderItems,
        Customer customer,
        Address deliveryAddress,
        OrderStatus status,
        String comments,
        LocalDateTime createdAt) {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public BigDecimal getTotalAmount() {
        return orderItems.stream()
                .map(item -> item.price().multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
