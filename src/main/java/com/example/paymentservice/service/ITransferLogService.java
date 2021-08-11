package com.example.paymentservice.service;


import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardRequestDto;
import com.example.paymentservice.dto.TransferLogDto;

public interface ITransferLogService {
//    UserTransferLogDto save(UserTransferLogDto userTransferLogDto);

    TransferLogDto createTransferLog(CardDto cardDto, CardRequestDto cardRequestDto, Boolean withdraw);
}
