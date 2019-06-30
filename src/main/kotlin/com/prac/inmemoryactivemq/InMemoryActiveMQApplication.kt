package com.prac.inmemoryactivemq

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class InMemoryActiveMQApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(InMemoryActiveMQApplication::class.java, *args)
        }
    }

}
