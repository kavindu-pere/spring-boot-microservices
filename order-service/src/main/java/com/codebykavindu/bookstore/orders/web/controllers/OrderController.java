package com.codebykavindu.bookstore.orders.web.controllers;

import com.codebykavindu.bookstore.orders.domain.OrderNotFoundException;
import com.codebykavindu.bookstore.orders.domain.OrderService;
import com.codebykavindu.bookstore.orders.domain.SecurityService;
import com.codebykavindu.bookstore.orders.domain.models.CreateOrderRequest;
import com.codebykavindu.bookstore.orders.domain.models.CreateOrderResponse;
import com.codebykavindu.bookstore.orders.domain.models.OrderDTO;
import com.codebykavindu.bookstore.orders.domain.models.OrderSummary;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kavindu Perera
 */
@RestController
@RequestMapping("api/v1/orders")
class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;
    private final SecurityService securityService;

    OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        String userName = securityService.getLoginUsername();
        log.info("Creating order for user={}", userName);
        return orderService.createOrder(userName, request);
    }

    @GetMapping
    List<OrderSummary> getOrders() {
        String username = securityService.getLoginUsername();
        log.info("Fetching orders for user={}", username);
        return orderService.findOrders(username);
    }

    @GetMapping("/{orderNumber}")
    OrderDTO getOrder(@PathVariable("orderNumber") String orderNumber) {
        log.info("Fetching order by id={}", orderNumber);
        String username = securityService.getLoginUsername();
        return orderService
                .findUserOrder(username, orderNumber)
                .orElseThrow(() -> new OrderNotFoundException(orderNumber));
    }
}
