package com.prac.inmemoryactivemq.model

import javax.validation.constraints.Size

data class UpdateMessage (
        @Size(min = 15, max = 20)
        val originalToken: String,
        @field:Size(min = 15, max = 20)
        val newToken: String,
        val originalExpiration: String,
        val newExpiration: String,

        val paymentProvider: String,
        val responseCode: String
)
