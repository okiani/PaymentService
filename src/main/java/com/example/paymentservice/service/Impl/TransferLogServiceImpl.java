package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CardRequestDto;
import com.example.paymentservice.dto.TransferLogDto;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.entity.TransferLog;
import com.example.paymentservice.repository.ITransferLogRepository;
import com.example.paymentservice.service.ITransferLogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class TransferLogServiceImpl implements ITransferLogService {

    private final ITransferLogRepository transferLogRepository;
    private ModelMapper modelMapper;

    public TransferLogServiceImpl(
            ITransferLogRepository transferLogRepository,
            ModelMapper modelMapper
    ) {
        this.transferLogRepository = transferLogRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransferLogDto createTransferLog(CardDto cardDto, CardRequestDto cardRequestDto, Boolean withdraw) {

        Card card = modelMapper.map(cardDto, Card.class);

        TransferLog transferLog = new TransferLog();
        transferLog.setCard(card);
        transferLog.setBalance(card.getBalance());

        if (withdraw) {
            transferLog.setWithdraw(cardRequestDto.getAmount());
            transferLog.setDeposit(null);

        }else {
            transferLog.setWithdraw(null);
            transferLog.setDeposit(cardRequestDto.getAmount());
        }

        transferLog.setDestinationCardNumber(cardRequestDto.getDestinationCardNumber());
        transferLog.setTrackingCode(String.valueOf(Math.random()));
        transferLog.setTransferAmount(cardRequestDto.getAmount());
        TransferLog transferLogEntity = transferLogRepository.save(transferLog);

        // convert entity to DTO
        return modelMapper.map(transferLogEntity, TransferLogDto.class);
    }
}
