package com.geanik.spring_modulith_playground.notification

import com.geanik.spring_modulith_playground.warehouse.OrderShippedEvent
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class NotificationService {

    @EventListener
    fun notifyCustomerOfShippedOrder(orderShippedEvent: OrderShippedEvent) {
        LOGGER.info("Customer notified of shipped order: ${orderShippedEvent.order}")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(NotificationService::class.java)
    }
}