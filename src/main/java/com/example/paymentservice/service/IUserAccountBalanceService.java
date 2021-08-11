package com.example.paymentservice.service;


import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardRequestDto;
import com.example.paymentservice.dto.UserAccountBalanceDto;
import com.example.paymentservice.dto.UserTransferLogDto;

public interface IUserAccountBalanceService {

//    String transferMoney(CardRequestDto cardRequestDto/*, UserTransferLogDto userTransferLogDto, String destinationCardNumber, Integer secondPassword*/);

    UserAccountBalanceDto findByUserId(Long userId);
}
