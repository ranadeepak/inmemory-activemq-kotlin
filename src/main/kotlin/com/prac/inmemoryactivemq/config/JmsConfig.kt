package com.prac.inmemoryactivemq.config

import org.apache.activemq.command.ActiveMQQueue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import javax.jms.Queue

@EnableJms
@Configuration
open class JmsConfig {
    @Bean
    open fun queue(): Queue {
        return ActiveMQQueue("inmemory.queue")
    }
}
