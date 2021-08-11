package com.example.paymentservice.controller;

import com.example.paymentservice.constant.JsonDictionary;
import com.example.paymentservice.dto.CardRequestDto;
import com.example.paymentservice.response.ResponseHandler;
import com.example.paymentservice.service.ITransferBalanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("api/v1/account")
public class TransferBalanceController {

    ITransferBalanceService transferBalanceService;

    public TransferBalanceController(ITransferBalanceService transferBalanceService) {
        this.transferBalanceService = transferBalanceService;
    }

    @PostMapping("/transfer-money")
    public ResponseEntity<Object> transferMoney(@RequestBody CardRequestDto cardRequestDto/*, UserTransferLogDto userTransferLogDto, String destination_card_number, Integer second_password*/) {

        transferBalanceService.transferMoney(cardRequestDto);
        return ResponseHandler.generateResponse(JsonDictionary.SUCCESS, 200, HttpStatus.OK, null);
    }
}
