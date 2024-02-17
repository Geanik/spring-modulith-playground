package com.geanik.spring_modulith_playground.warehouse

import com.geanik.spring_modulith_playground.order.Order

data class OrderShippedEvent(val order: Order)
