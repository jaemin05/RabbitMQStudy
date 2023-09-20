package com.example.rabbitmqstudy.controller.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class MessageDto @JsonCreator constructor (
    @JsonProperty("title") val title: String,
    @JsonProperty("content") val content: String,
)
