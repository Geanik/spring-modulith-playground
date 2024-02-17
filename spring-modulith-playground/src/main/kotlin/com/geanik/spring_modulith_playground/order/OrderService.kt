package com.geanik.spring_modulith_playground.order

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*
import kotlin.random.Random

@Service
class OrderService(
    private val eventPublisher: ApplicationEventPublisher,
) {
    @Scheduled(fixedDelay = 5_000)
    fun produceOrders() {
        placeOrder(
            Order(
                product = UUID.randomUUID().toString(), price = Random.nextDouble(3.99, 9.99).toBigDecimal()
            )
        )
    }

    fun placeOrder(order: Order) {
        LOGGER.info("Order placed: $order")
        eventPublisher.publishEvent(order.toPlacedEvent())
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(OrderService::class.java)

        private fun Order.toPlacedEvent(): OrderPlacedEvent = OrderPlacedEvent(
            order = this,
            timeStamp = Instant.now()
        )
    }
}
