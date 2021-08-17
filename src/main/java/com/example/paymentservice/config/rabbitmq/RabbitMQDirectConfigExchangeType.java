package com.example.paymentservice.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfigExchangeType {

    @Bean
    Queue NotificationQueue() {
        return new Queue("NotificationQueue", false);
    }

    @Bean
    Binding NotificationBinding(Queue NotificationQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(NotificationQueue).to(directExchange).with("notification");
    }

    /*@Bean
    Queue marketingQueue() {
        return new Queue("marketingQueue", false);
    }

    @Bean
    Queue financeQueue() {
        return new Queue("financeQueue", false);
    }

    @Bean
    Queue adminQueue() {
        return new Queue("adminQueue", false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding marketingBinding(Queue marketingQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(marketingQueue).to(directExchange).with("marketing");
    }

    @Bean
    Binding financeBinding(Queue financeQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(financeQueue).to(directExchange).with("finance");
    }

    @Bean
    Binding adminBinding(Queue adminQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(adminQueue).to(directExchange).with("admin");
    }*/
}
