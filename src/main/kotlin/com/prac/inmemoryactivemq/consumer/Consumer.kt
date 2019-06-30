package com.prac.inmemoryactivemq.consumer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.prac.inmemoryactivemq.model.UpdateMessage
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class Consumer {
    val mapper = jacksonObjectMapper().registerModule(KotlinModule())

    init {
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
    }

    @JmsListener(destination = "inmemory.queue")
    fun listener(msg: String) {
        val json = msg.replace("\u2028", "")
        val updateMessage = mapper.readValue(json, UpdateMessage::class.java)
        println("Received Message: ${updateMessage}")
    }
}
