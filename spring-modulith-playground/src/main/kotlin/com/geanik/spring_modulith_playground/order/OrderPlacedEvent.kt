package com.geanik.spring_modulith_playground.order

import java.time.Instant

data class OrderPlacedEvent(val order: Order, val timeStamp: Instant)
