package com.codebykavindu.bookstore.orders.domain;

/**
 * @author Kavindu Perera
 */
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forOrderNumber(String orderNumber) {
        return new OrderNotFoundException("Order with Number " + orderNumber + " not found");
    }
}
