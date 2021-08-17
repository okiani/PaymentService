package com.example.paymentservice.service;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardRequestDto;
import com.example.paymentservice.dto.TransferBalanceDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ITransferBalanceService {

    void transferMoney(CardRequestDto cardRequestDto);

    TransferBalanceDto createTransferBalance(CardDto cardDto, CardRequestDto cardRequestDto, Boolean withdraw);
}
