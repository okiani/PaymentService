package com.example.paymentservice.Service;

import com.example.paymentservice.Entity.Card;
import javassist.NotFoundException;

import java.util.List;

public interface ICardService {

    List<Card> findAll();

    Card findById(Long id) throws NotFoundException;

    Card save(Card card);

    Card update(Long id, Card card) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Card findByCardNumber(String cardNumber) throws NotFoundException;
}
