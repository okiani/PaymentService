package com.example.paymentservice.Service.Impl;

import com.example.paymentservice.Entity.Card;
import com.example.paymentservice.Repository.ICardRepository;
import com.example.paymentservice.Service.ICardService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService{

    ICardRepository cardRepository;

    public CardServiceImpl(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findById(Long id) throws NotFoundException {

        Card card = cardRepository.findById(id);
        if (card != null){
            return card;
        }
        throw new NotFoundException("Not Found");
    }

    @Override
    public Card findByCardNumber(String cardNumber) throws NotFoundException {
        Card card = cardRepository.findByCardNumber(cardNumber);
        if (card != null){
            return card;
        }
        throw new NotFoundException("Not Found");
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(Long id, Card card) throws NotFoundException {
        Card existingCard = cardRepository.findById(id);

        if (existingCard != null) {
            existingCard.setCardNumber(card.getCardNumber());
            existingCard.setCardType(card.getCardType());
            existingCard.setHolderName(card.getHolderName());
            existingCard.setExpiredDate(card.getExpiredDate());
            existingCard.setStatus(card.getStatus());

            return cardRepository.save(existingCard);
        }

        throw new NotFoundException("Not Found");
    }

    @Override
    public void delete(Long id) throws NotFoundException {

        Card existingCard = cardRepository.findById(id);

        if (existingCard != null) {
            cardRepository.deleteById(id);
            return;
        }

        throw new NotFoundException("Not Found");
    }
}
