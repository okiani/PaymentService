package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.UserTransferLogDto;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.entity.User;
import com.example.paymentservice.entity.UserTransferLog;
import com.example.paymentservice.repository.IUserTransferLogRepository;
import com.example.paymentservice.service.IUserTransferLogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserTransferLogServiceImpl implements IUserTransferLogService {

    private final IUserTransferLogRepository userTransferLogRepository;
    private ModelMapper modelMapper;

    public UserTransferLogServiceImpl(
            IUserTransferLogRepository userTransferLogRepository,
            ModelMapper modelMapper
    ) {
        this.userTransferLogRepository = userTransferLogRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserTransferLogDto createLog(User user, Card card, Double price, Card destinationCard) {
        UserTransferLog userTransferLog = new UserTransferLog();
        userTransferLog.setUser(user);
        userTransferLog.setCard(card);
        userTransferLog.setPrice(price);
        userTransferLog.setDestinationCardNumber(destinationCard.getCardNumber());
        userTransferLog.setTrackingCode(String.valueOf(Math.random()));
        UserTransferLog userTransferLogEntity = userTransferLogRepository.save(userTransferLog);

        // convert entity to DTO
        return modelMapper.map(userTransferLogEntity, UserTransferLogDto.class);
    }
}
