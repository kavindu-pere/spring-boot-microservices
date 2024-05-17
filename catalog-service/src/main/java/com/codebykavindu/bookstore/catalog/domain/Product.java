package com.codebykavindu.bookstore.catalog.domain;

import java.math.BigDecimal;

/**
 * @author Kavindu Perera
 */
public record Product(String code, String name, String description, String imageUrl, BigDecimal price) {}
