package com.example.paymentservice.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    //uncomment below lines
    /*@Bean
    Queue paymentQueueTopic() {
        return new Queue("paymentQueueTopic", false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    Binding paymentBindingTopic(Queue paymentQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(paymentQueueTopic).to(topicExchange).with("queue.payment");
    }*/




    /*@Bean
    Queue marketingQueueTopic() {
        return new Queue("marketingQueueTopic", false);
    }

    @Bean
    Queue financeQueueTopic() {
        return new Queue("financeQueueTopic", false);
    }

    @Bean
    Queue adminQueueTopic() {
        return new Queue("adminQueueTopic", false);
    }

    @Bean
    Queue allQueueTopic() {
        return new Queue("allQueueTopic", false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    Binding marketingBindingTopic(Queue marketingQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(marketingQueueTopic).to(topicExchange).with("queue.marketing");
    }

    @Bean
    Binding financeBindingTopic(Queue financeQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(financeQueueTopic).to(topicExchange).with("queue.finance");
    }

    @Bean
    Binding adminBindingTopic(Queue adminQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(adminQueueTopic).to(topicExchange).with("queue.admin");
    }

    @Bean
    Binding allBinding(Queue allQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueueTopic).to(topicExchange).with("queue.*");
    }*/

}
