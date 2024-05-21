package com.codebykavindu.bookstore.orders.jobs;

import com.codebykavindu.bookstore.orders.domain.OrderEventService;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Kavindu Perera
 */
@Component
class OrderEventPublishingJob {
    private static final Logger log = LoggerFactory.getLogger(OrderEventPublishingJob.class);

    private final OrderEventService orderEventService;

    OrderEventPublishingJob(OrderEventService orderEventService) {
        this.orderEventService = orderEventService;
    }

    @Scheduled(cron = "${orders.publish-order-events-job-cron}")
    public void publishOrderEvents() {
        log.info("Publishing Order Events at {}", Instant.now());
        orderEventService.publishOrderEvents();
    }
}
