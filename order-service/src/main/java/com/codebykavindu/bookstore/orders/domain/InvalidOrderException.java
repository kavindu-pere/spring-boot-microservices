package com.codebykavindu.bookstore.orders.domain;

/**
 * @author Kavindu Perera
 */
public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException(String message) {
        super(message);
    }
}
