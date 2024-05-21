package com.codebykavindu.bookstore.orders.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kavindu Perera
 */
interface OrderEventRepository extends JpaRepository<OrderEventEntity, Long> {}
