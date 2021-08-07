package com.example.paymentservice.controller;

import com.example.paymentservice.dto.CardDto;
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
    public List<CardDto> findAll() {

        return cardService.findAll();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<CardDto> detail(@PathVariable(name = "id") Long id) {

        CardDto card = cardService.findById(id);
        return ResponseEntity.ok().body(card);
    }

    @PostMapping("/create")
    public ResponseEntity<CardDto> save(@RequestBody CardDto cardDto) {

        CardDto cardResponse = cardService.save(cardDto);
        return new ResponseEntity<CardDto>(cardResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CardDto> update(@PathVariable long id, @RequestBody CardDto cardDto) {

        CardDto cardResponse = cardService.update(id, cardDto);
        return ResponseEntity.ok().body(cardResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {

        cardService.delete(id);
        return new ResponseEntity<>("card number: " + id + " removed!", HttpStatus.OK);
    }

    @GetMapping("/card-numbers")
    public List<String> getAllCardNumber() {
        return cardService.getAllCardNumber();
    }
}
