package com.codebykavindu.bookstore.orders.domain;

import org.springframework.stereotype.Service;

/**
 * @author Kavindu Perera
 */
@Service
public class SecurityService {

    public String getLoginUsername() {
        return "user";
    }
}
