package com.codebykavindu.bookstore.orders.domain.models;

/**
 * @author Kavindu Perera
 */
public record OrderSummary(String orderNumber, OrderStatus status) {}
