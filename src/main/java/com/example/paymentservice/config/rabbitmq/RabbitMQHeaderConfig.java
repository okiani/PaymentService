package com.example.paymentservice.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

    //uncomment below lines
    /*@Bean
    Queue paymentQueueHeader() {
        return new Queue("paymentQueueHeader", false);
    }

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange("header-exchange");
    }

    @Bean
    Binding paymentBindingHeader(Queue paymentQueueHeader, HeadersExchange headerExchange) {
        return BindingBuilder.bind(paymentQueueHeader).to(headerExchange).where("department").matches("payment");
    }*/


    /*@Bean
    Queue marketingQueueHeader() {
        return new Queue("marketingQueueHeader", false);
    }

    @Bean
    Queue financeQueueHeader() {
        return new Queue("financeQueueHeader", false);
    }

    @Bean
    Queue adminQueueHeader() {
        return new Queue("adminQueueHeader", false);
    }

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange("header-exchange");
    }

    @Bean
    Binding marketingBindingHeader(Queue marketingQueueHeader, HeadersExchange headerExchange) {
        return BindingBuilder.bind(marketingQueueHeader).to(headerExchange).where("department").matches("marketing");
    }

    @Bean
    Binding financeBindingHeader(Queue financeQueueHeader, HeadersExchange headerExchange) {
        return BindingBuilder.bind(financeQueueHeader).to(headerExchange).where("department").matches("finance");
    }

    @Bean
    Binding adminBindingHeader(Queue adminQueueHeader, HeadersExchange headerExchange) {
        return BindingBuilder.bind(adminQueueHeader).to(headerExchange).where("department").matches("admin");
    }*/

}
