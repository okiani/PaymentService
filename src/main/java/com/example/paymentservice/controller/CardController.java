package com.example.paymentservice.controller;

import com.example.paymentservice.constant.JsonDictionary;
import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardNumberDto;
import com.example.paymentservice.transformer.mappers.response.ResponseHandler;
import com.example.paymentservice.service.ICardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("api/v1/card")
public class CardController {

    ICardService cardService;

    public CardController(ICardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> findAll() {

        List<CardDto> cardDto = cardService.findAll();
        return ResponseHandler.generateResponse(JsonDictionary.SUCCESS, 200, HttpStatus.OK, cardDto);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Object> detail(@PathVariable(name = "id") Long id) {

        CardDto cardDto = cardService.findById(id);
        return ResponseHandler.generateResponse(JsonDictionary.SUCCESS, 200, HttpStatus.OK, cardDto);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> save(@RequestBody CardDto cardDto) {

        CardDto cardResponse = cardService.save(cardDto);
        return ResponseHandler.generateResponse(JsonDictionary.SUCCESS, 200, HttpStatus.CREATED, cardResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody CardDto cardDto) {

        CardDto cardResponse = cardService.update(id, cardDto);
        return ResponseHandler.generateResponse(JsonDictionary.SUCCESS, 200, HttpStatus.OK, cardResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") long id) {

        cardService.delete(id);
        return ResponseHandler.generateResponse(JsonDictionary.SUCCESS, 200, HttpStatus.OK, null);
    }

    @GetMapping("/card-numbers")
    public ResponseEntity<Object> getAllCardNumber() {

        List<CardNumberDto> cardResponse = cardService.getAllCardNumber();
        return ResponseHandler.generateResponse(JsonDictionary.SUCCESS, 200, HttpStatus.OK, cardResponse);
    }
}
