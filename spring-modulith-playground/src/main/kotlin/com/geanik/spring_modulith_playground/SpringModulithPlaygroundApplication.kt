package com.geanik.spring_modulith_playground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SpringModulithPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<SpringModulithPlaygroundApplication>(*args)
}
