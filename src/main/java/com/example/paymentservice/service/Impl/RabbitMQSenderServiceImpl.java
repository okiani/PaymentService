package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.SmsRequestDto;
import com.example.paymentservice.service.IRabbitMQSenderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RabbitMQSenderServiceImpl implements IRabbitMQSenderService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${notification.rabbitmq.exchange}")
    private String exchange;

    @Value("${notification.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    private ObjectMapper objectMapper;

    public RabbitMQSenderServiceImpl(AmqpTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(Object message) {
        rabbitTemplate.convertAndSend(exchange, routingkey, message);
    }

     /* String orderJson = objectMapper.writeValueAsString(message);
        Message msg = MessageBuilder
                .withBody(orderJson.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();*/
}
