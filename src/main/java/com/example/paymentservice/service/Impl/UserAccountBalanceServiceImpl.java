package com.example.paymentservice.service.Impl;

import com.example.paymentservice.constant.ErrorCode;
import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CurrencyDto;
import com.example.paymentservice.dto.UserAccountBalanceDto;
import com.example.paymentservice.entity.*;
import com.example.paymentservice.exception.NotFoundException;
import com.example.paymentservice.exception.OverDraftException;
import com.example.paymentservice.repository.*;
import com.example.paymentservice.service.ICardService;
import com.example.paymentservice.service.IUserAccountBalanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountBalanceServiceImpl implements IUserAccountBalanceService {

    private ModelMapper modelMapper;
    private Environment env;
    private final IUserAccountBalanceRepository userAccountBalanceRepository;
    private final ICurrencyRepository currencyRepository;
    private final ICardRepository cardRepository;
    private final IUserRepository userRepository;
    private final IUserTransferLogRepository userTransferLogRepository;
    private final ITransferReportRepository transferReportRepository;

    public UserAccountBalanceServiceImpl(
            IUserAccountBalanceRepository userAccountBalanceRepository,
            ICurrencyRepository currencyRepository,
            ICardRepository cardRepository,
            IUserRepository userRepository,
            IUserTransferLogRepository userTransferLogRepository,
            ITransferReportRepository transferReportRepository,
            ModelMapper modelMapper,
            Environment env
    ) {
        this.userAccountBalanceRepository = userAccountBalanceRepository;
        this.currencyRepository = currencyRepository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.userTransferLogRepository = userTransferLogRepository;
        this.transferReportRepository = transferReportRepository;
        this.modelMapper = modelMapper;
        this.env = env;
    }

    @Override
    public String transferMoney() {
        // todo:for transfer money we need to:

        //todo: 1- load currency that is should be RIAL and get 'RIAL' from config
        //get default currency from env
        Currency currency = currencyRepository.findByDescriptor(env.getProperty("currency_descriptor"));
        
        //todo: 2- check account balances is != 0 by userId
        //load current user (source)
        User user = userRepository.findById(Long.valueOf(env.getProperty("user_id")))
                .orElseThrow(() -> new NotFoundException("User Id : " + env.getProperty("user_id")));

        Card card = cardRepository.findByUserId(user.getId());

        UserAccountBalance userAccountBalance = userAccountBalanceRepository.findByUserId(user.getId());

        //todo: find destination account number info
        //should be set card number from request
        Card destinationCard = cardRepository.findByCardNumber("5894631514360944")
                .orElseThrow(() -> new NotFoundException("Destination Card Id : " /*+ cardnumber*/));

        //user destination
        UserAccountBalance userAccountBalanceDestination = userAccountBalanceRepository.findByUserId(destinationCard.getUser().getId());

        // price should be set from request
        if (userAccountBalance.getAccountBalance().compareTo(1000.0) < 0){
            throw new OverDraftException("Account with id:" + userAccountBalance.getId() + " does not have enough balance to transfer.", ErrorCode.ACCOUNT_ERROR);
        }

        userAccountBalance.setAccountBalance(userAccountBalance.getAccountBalance() - 10000);
        userAccountBalanceRepository.save(userAccountBalance);

        userAccountBalanceDestination.setAccountBalance(userAccountBalanceDestination.getAccountBalance() + 10000);
        userAccountBalanceRepository.save(userAccountBalanceDestination);

        /*------------------------------------------------*/
        //todo: 3- save destination card number and price and tracking code by userId & cardId
        UserTransferLog userTransferLog = new UserTransferLog();
        userTransferLog.setUser(user);
        userTransferLog.setCard(card);
        // price should be set from request
        userTransferLog.setPrice(100.0);
        userTransferLog.setDestinationCardNumber(destinationCard.getCardNumber());
        userTransferLog.setTrackingCode(String.valueOf(Math.random()));
        userTransferLogRepository.save(userTransferLog);

        //todo: 4- after save The data mentioned above wh should save transfer report table:
        //todo: 4-1: save user transfer log id with message and set success true.
        //todo: 4-2: check operation is successfully or unsuccessfully.
        TransferReport transferReport = new TransferReport();
        transferReport.setUserTransferLog(userTransferLog);
        transferReport.setMessage("operation accomplished successfully");
        transferReport.setSuccess(true);
        transferReportRepository.save(transferReport);

        return null;
    }
}
