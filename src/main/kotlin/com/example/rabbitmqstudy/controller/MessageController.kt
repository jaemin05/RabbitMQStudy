package com.example.rabbitmqstudy.controller

import com.example.rabbitmqstudy.controller.dto.MessageDto
import com.example.rabbitmqstudy.service.MessageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class MessageController(
    private val messageService: MessageService,
) {

    @PostMapping
    fun sendMessage(@Valid @RequestBody messageDto: MessageDto) {
        messageService.sendMessage(messageDto)
    }
}