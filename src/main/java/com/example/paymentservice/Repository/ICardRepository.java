package com.example.paymentservice.Repository;

import com.example.paymentservice.Entity.Card;

import java.util.List;

public interface ICardRepository {

    List<Card> findAll();
    Card findById(Long id);
    Card findByCardNumber(String cardNumber);
}
