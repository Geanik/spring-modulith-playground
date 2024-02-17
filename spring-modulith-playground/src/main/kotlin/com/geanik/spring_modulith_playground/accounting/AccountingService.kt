package com.geanik.spring_modulith_playground.accounting

import com.geanik.spring_modulith_playground.order.OrderPlacedEvent
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class AccountingService {

    @EventListener
    fun generateInvoiceForPlacedOrder(orderPlacedEvent: OrderPlacedEvent) {
        LOGGER.info("Creating invoice for order ${orderPlacedEvent.order}")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(AccountingService::class.java)
    }
}