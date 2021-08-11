package com.example.paymentservice.service.Impl;

import com.example.paymentservice.constant.JsonDictionary;
import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardNumberDto;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.entity.User;
import com.example.paymentservice.exception.NotFoundException;
import com.example.paymentservice.repository.ICardRepository;
import com.example.paymentservice.repository.IUserRepository;
import com.example.paymentservice.service.ICardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ModelMapper modelMapper;

    private final ICardRepository cardRepository;
    private final IUserRepository userRepository;
    private Environment env;

    public CardServiceImpl(ICardRepository cardRepository,
                           IUserRepository userRepository,
                           Environment env) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.env = env;
    }

    @Override
    public List<CardDto> findAll() {

        List<CardDto> cardDto = cardRepository.findAll()
                .stream()
                .map(card -> modelMapper.map(card, CardDto.class))
                .collect(Collectors.toList());

        if (cardDto.isEmpty()) {
            throw new NotFoundException(JsonDictionary.NOT_FOUND, 404, HttpStatus.NOT_FOUND);
        }

        return cardDto;
    }

    @Override
    public CardDto save(CardDto cardDto) {

        User user = userRepository.findById(Long.valueOf(env.getProperty("user_id")))
                .orElseThrow(() -> new NotFoundException("Not Found User Id: " + env.getProperty("user_id"), 404));

        // convert DTO to entity
        Card cardRequest = modelMapper.map(cardDto, Card.class);

        Card card = new Card();
        card.setUser(user);
        card.setHolderName(cardRequest.getHolderName());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setCardType(cardRequest.getCardType());
        card.setCvv2(cardRequest.getCvv2());
        card.setExpiredDate(cardRequest.getExpiredDate());
        card.setStatus(cardRequest.getStatus());
        card.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        card.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));

        Card cardResponseEntity = cardRepository.save(card);

        // convert entity to DTO
        return modelMapper.map(cardResponseEntity, CardDto.class);
    }

    @Override
    public CardDto update(Long id, CardDto cardDto) {

        // convert DTO to Entity
        Card cardRequest = modelMapper.map(cardDto, Card.class);

        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Card Id: " + id, 404));

        card.setBalance(cardRequest.getBalance());
        card.setHolderName(cardRequest.getHolderName());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setCardType(cardRequest.getCardType());
        card.setCvv2(cardRequest.getCvv2());
        card.setExpiredDate(cardRequest.getExpiredDate());
        card.setStatus(cardRequest.getStatus());
        card.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        cardRepository.save(card);

        // entity to DTO
        return modelMapper.map(card, CardDto.class);
    }

    @Override
    public void delete(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Card Id: " + id, 404));

        cardRepository.delete(card);
    }

    @Override
    public CardDto findById(Long id) {

        Optional<Card> card = cardRepository.findById(id);
        if (card.isPresent()) {
            // convert entity to DTO
            return modelMapper.map(card.get(), CardDto.class);
        }
        throw new NotFoundException("Not Found Card Id: " + id, 404);
    }

    @Override
    public CardDto findByCardNumber(String cardNumber) {

        Optional<Card> card = cardRepository.findByCardNumber(cardNumber);
        if (card.isPresent()) {
            return modelMapper.map(card.get(), CardDto.class);
        }
        throw new NotFoundException("Not Found Card Number: " + cardNumber, 404);
    }

    @Override
    public CardDto findByUserId(Long userId) {

        Optional<Card> card = cardRepository.findByUserId(userId);

        if (card.isPresent()) {
            // convert entity to DTO
            return modelMapper.map(card.get(), CardDto.class);
        }
        throw new NotFoundException("Not Found Card User Id: " + userId, 404);
    }

    @Override
    public CardDto findByUserIdByCardNumber(Long userId, String cardNumber) {

        Optional<Card> card = cardRepository.findByUserIdByCardNumber(userId, cardNumber);

        if (card.isPresent()) {
            // convert entity to DTO
            return modelMapper.map(card.get(), CardDto.class);
        }
        throw new NotFoundException("Not Found Card with User Id: " + userId + " and " + " CardNumber: " + cardNumber, 404);
    }

    @Override
    public List<CardNumberDto> getAllCardNumber() {

        List<CardNumberDto> cardNumberDtoList = cardRepository.getAllCardNumber()
                .stream()
                .map(card -> modelMapper.map(card, CardNumberDto.class))
                .collect(Collectors.toList());

        if (cardNumberDtoList.isEmpty()) {
            throw new NotFoundException(JsonDictionary.NOT_FOUND, 404, HttpStatus.NOT_FOUND);
        }

        return cardNumberDtoList;
    }
}
