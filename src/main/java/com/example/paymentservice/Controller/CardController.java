package com.example.paymentservice.Controller;

import com.example.paymentservice.Entity.Card;
import com.example.paymentservice.Service.ICardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<?> findAll() {

        List<Card> cardList = cardService.findAll();

        if (cardList != null) {
            HashMap<String, Object> res = new HashMap<>();
            res.put("status_code", 200);
            res.put("message", "Find list card success");
            res.put("data", cardList);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        HashMap<String, Object> res = new HashMap<>();
        res.put("status_code", 404);
        res.put("message", "not found");

        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/detail/{cardId}")
    public ResponseEntity<?> detail(@PathVariable("cardId") Long cardId) throws NotFoundException {

        Card updateCard = cardService.findById(cardId);

        HashMap<String, Object> res = new HashMap<>();
        res.put("status_code", 200);
        res.put("message", "Find detail card success");
        res.put("data", updateCard);

        return new ResponseEntity<>(updateCard, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Card card) {

        Card newCard = cardService.save(card);

        //todo: this section for test
        HashMap<String, Object> res = new HashMap<>();
        res.put("status_code", 200);
        res.put("message", "create card successfully.");
        res.put("data", newCard);

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/update/{cardId}")
    public ResponseEntity<?> update(@PathVariable("cardId") Long cardId, @RequestBody Card card) throws NotFoundException {

        Card updateCard = cardService.update(cardId, card);

        HashMap<String, Object> res = new HashMap<>();
        res.put("status_code", 200);
        res.put("message", "Update card successfully");
        res.put("data", updateCard);

        return new ResponseEntity<>(updateCard, HttpStatus.OK);
    }

    @DeleteMapping({"/delete/{cardId}"})
    public ResponseEntity<?> delete(@PathVariable("cardId") Long cardId) throws NotFoundException {
        cardService.delete(cardId);
        return new ResponseEntity<>("card number: " + cardId + " removed!", HttpStatus.NO_CONTENT);
    }
}
