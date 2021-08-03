package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.exception.NotFoundException;
import com.example.paymentservice.repository.ICardRepository;
import com.example.paymentservice.service.ICardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ModelMapper modelMapper;

    private final ICardRepository cardRepository;

    public CardServiceImpl(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<CardDto> findAll() {

        return cardRepository.findAll()
                .stream()
                .map(card -> modelMapper.map(card, CardDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CardDto save(CardDto cardDto) {

        // convert DTO to entity
        Card cardRequest = modelMapper.map(cardDto, Card.class);
        Card card = cardRepository.save(cardRequest);

        // convert entity to DTO
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    public CardDto update(Long id, CardDto cardDto) {
/*// convert DTO to Entity
        Card cardRequest = modelMapper.map(cardDto, Card.class);
        Card card = cardService.update(id, cardRequest);

        // entity to DTO
        CardDto cardResponse = modelMapper.map(card, CardDto.class);
        return ResponseEntity.ok().body(cardResponse);*/

        // convert DTO to Entity
        Card cardRequest = modelMapper.map(cardDto, Card.class);

        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Card Id : " + id));

        card.setCardNumber(cardRequest.getCardNumber());
        card.setCardType(cardRequest.getCardType());
        card.setHolderName(cardRequest.getHolderName());
        card.setExpiredDate(cardRequest.getExpiredDate());
        card.setCvv2(cardRequest.getCvv2());
        card.setStatus(cardRequest.getStatus());
        cardRepository.save(card);

        // entity to DTO
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    public void delete(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Card Id : " + id));

        cardRepository.delete(card);
    }

    @Override
    public CardDto findById(Long id) {

        Optional<Card> card = cardRepository.findById(id);
        if (card.isPresent()) {
            // convert entity to DTO
            return modelMapper.map(card.get(), CardDto.class);
        }
        throw new NotFoundException("Card Id: " + id);
    }

    @Override
    public CardDto findByCardNumber(String cardNumber) {

        Optional<Card> card = cardRepository.findByCardNumber(cardNumber);
        if (card.isPresent()) {
            return modelMapper.map(card.get(), CardDto.class);
        } else {
            throw new NotFoundException("Card Number: " + cardNumber);
        }
    }
}
