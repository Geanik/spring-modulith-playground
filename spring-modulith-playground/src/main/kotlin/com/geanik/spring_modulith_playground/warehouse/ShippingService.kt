package com.geanik.spring_modulith_playground.warehouse

import com.geanik.spring_modulith_playground.order.Order
import com.geanik.spring_modulith_playground.order.OrderPlacedEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class ShippingService(
    private val eventPublisher: ApplicationEventPublisher,
) {

    @EventListener
    fun shipOrder(orderPlacedEvent: OrderPlacedEvent) {
        LOGGER.info("Shipping order: ${orderPlacedEvent.order}")
        eventPublisher.publishEvent(orderPlacedEvent.order.toShippedEvent())
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ShippingService::class.java)

        private fun Order.toShippedEvent() = OrderShippedEvent(
            order = this
        )
    }
}
