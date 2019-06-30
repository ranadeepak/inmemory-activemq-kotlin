package com.prac.inmemoryactivemq.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.jms.Queue

@RestController
class ProducerResource(
        @Autowired private val queue: Queue,
        @Autowired private val jmsTemplate: JmsTemplate) {

    @PostMapping("/publisher")
    fun publish(@RequestBody msg: String): ResponseEntity<String> {
        jmsTemplate.convertAndSend(queue, msg)
        return ResponseEntity("Message published successfully!", HttpStatus.OK)
    }
}
