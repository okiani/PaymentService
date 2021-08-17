package com.example.paymentservice.service;


public interface IRabbitMQSenderService {

    void send(Object message);
}
