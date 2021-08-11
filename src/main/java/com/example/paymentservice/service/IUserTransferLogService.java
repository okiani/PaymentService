package com.example.paymentservice.service;


import com.example.paymentservice.dto.UserTransferLogDto;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.entity.User;
import com.example.paymentservice.entity.UserTransferLog;

public interface IUserTransferLogService {
//    UserTransferLogDto save(UserTransferLogDto userTransferLogDto);

    UserTransferLogDto createLog(User user, Card card, Double price, Card destinationCard);
}
