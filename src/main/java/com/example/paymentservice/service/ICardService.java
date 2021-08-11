package com.example.paymentservice.service;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardNumberDto;

import java.util.List;

public interface ICardService {

    List<CardDto> findAll();

    CardDto save(CardDto cardDto);

    CardDto update(Long id, CardDto cardDto);

    void delete(Long id);

    CardDto findById(Long id);

    CardDto findByUserId(Long id);

    CardDto findByCardNumber(String cardNumber);

    CardDto findByUserIdByCardNumber(Long id, String cardNumber);

    List<CardNumberDto> getAllCardNumber();
}
