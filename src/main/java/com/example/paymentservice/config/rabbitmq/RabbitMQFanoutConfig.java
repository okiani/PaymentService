package com.example.paymentservice.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    //uncomment below lines
    /*@Bean
    Queue paymentQueueFanout() {
        return new Queue("paymentQueue-f", false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding paymentBindingFanout(Queue paymentQueueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(paymentQueueFanout).to(fanoutExchange);
    }*/

    /*@Bean
    Queue marketingQueueFanout() {
        return new Queue("marketingQueue-f", false);
    }

    @Bean
    Queue financeQueueFanout() {
        return new Queue("financeQueue-f", false);
    }

    @Bean
    Queue adminQueueFanout() {
        return new Queue("adminQueue-f", false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding marketingBindingFanout(Queue marketingQueueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(marketingQueueFanout).to(fanoutExchange);
    }

    @Bean
    Binding financeBindingFanout(Queue financeQueueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(financeQueueFanout).to(fanoutExchange);
    }

    @Bean
    Binding adminBindingFanout(Queue adminQueueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(adminQueueFanout).to(fanoutExchange);
    }*/

}
