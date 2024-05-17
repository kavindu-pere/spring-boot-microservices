package com.codebykavindu.bookstore.catalog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kavindu Perera
 */
interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
