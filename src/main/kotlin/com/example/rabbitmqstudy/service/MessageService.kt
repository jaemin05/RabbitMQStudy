package com.example.rabbitmqstudy.service

import com.example.rabbitmqstudy.controller.dto.MessageDto
import org.slf4j.Logger
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val rabbitTemplate: RabbitTemplate
) {
    companion object {
        val logger: Logger = org.slf4j.LoggerFactory.getLogger(MessageService::class.java)
    }
    fun sendMessage(messageDto: MessageDto) {
        logger.info("message sent: {}", messageDto.toString())
        rabbitTemplate.convertAndSend("hello.exchange", "hello.key", messageDto)
    }

    @RabbitListener(queues = ["hello.queue"])
    fun receiveMessage(messageDto: MessageDto) {
        logger.info("message received: {}", messageDto.toString())
    }
}