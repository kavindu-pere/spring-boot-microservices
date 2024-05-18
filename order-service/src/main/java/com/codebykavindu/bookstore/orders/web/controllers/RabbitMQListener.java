package com.codebykavindu.bookstore.orders.web.controllers;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Kavindu Perera
 */
@Service
class RabbitMQListener {
    private static final Logger LOGGER = getLogger(RabbitMQListener.class);

    @RabbitListener(queues = "${orders.new-orders-queue}")
    public void handleNewOrder(MyPayload payload) {
        LOGGER.info("New Order: {}", payload.content());
    }

    @RabbitListener(queues = "${orders.delivered-orders-queue}")
    public void handleDeliveredOrder(MyPayload payload) {
        LOGGER.info("Delivered Order: {}", payload.content());
    }
}
