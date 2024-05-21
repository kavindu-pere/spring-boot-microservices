package com.codebykavindu.bookstore.orders.domain.models;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Kavindu Perera
 */
public record OrderCreatedEvent(
        String eventId,
        String orderNumber,
        Set<OrderItem> items,
        Customer customer,
        Address deliveryAddress,
        LocalDateTime createdAt) {}
