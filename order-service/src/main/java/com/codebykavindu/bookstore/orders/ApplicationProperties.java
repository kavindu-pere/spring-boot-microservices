package com.codebykavindu.bookstore.orders;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Kavindu Perera
 */
@ConfigurationProperties(prefix = "orders")
public record ApplicationProperties(
        String orderEventsExchange,
        String newOrdersQueue,
        String deliveredOrdersQueue,
        String cancelledOrdersQueue,
        String errorOrdersQueue) {}
