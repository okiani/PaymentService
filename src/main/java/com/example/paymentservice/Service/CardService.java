package com.example.paymentservice.Service;

import com.example.paymentservice.Entity.Card;
import com.example.paymentservice.Repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private ICardRepository cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id){
        return cardRepository.findById(id);
    }

    public Card findByCardNumber(String cardNumber){
        return cardRepository.findByCardNumber(cardNumber);
    }
}
