package com.example.paymentservice.service;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardRequestDto;
import com.example.paymentservice.dto.TransferBalanceDto;

public interface ITransferBalanceService {

    void transferMoney(CardRequestDto cardRequestDto/*, UserTransferLogDto userTransferLogDto, String destinationCardNumber, Integer secondPassword*/);

    TransferBalanceDto createTransferBalance(CardDto cardDto, CardRequestDto cardRequestDto, Boolean withdraw);
}
