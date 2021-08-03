package com.example.paymentservice.service;

import com.example.paymentservice.dto.CardDto;

import java.util.List;

public interface ICardService {

    List<CardDto> findAll();

    CardDto save(CardDto cardDto);

    CardDto update(Long id, CardDto cardDto);

    void delete(Long id);

    CardDto findById(Long id);

    CardDto findByCardNumber(String cardNumber);
}
