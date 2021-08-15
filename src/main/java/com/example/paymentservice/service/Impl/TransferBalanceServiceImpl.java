package com.example.paymentservice.service.Impl;

import com.example.paymentservice.constant.ErrorCode;
import com.example.paymentservice.dto.*;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.entity.TransferBalance;
import com.example.paymentservice.entity.User;
import com.example.paymentservice.exception.NotFoundException;
import com.example.paymentservice.exception.OverDraftException;
import com.example.paymentservice.repository.ITransferBalanceRepository;
import com.example.paymentservice.service.*;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Service
public class TransferBalanceServiceImpl implements ITransferBalanceService {

    private final ITransferBalanceRepository transferBalanceRepository;
    private Environment env;
    private final ICurrencyService currencyService;
    private final IUserService userService;
    private final ICardService cardService;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;

    @Value("${resource.notification}/email")
    private String emailResource;

    @Value("${resource.notification}/sms")
    private String smsResource;

    public TransferBalanceServiceImpl(
            ITransferBalanceRepository transferBalanceRepository,
            ICurrencyService currencyService,
            IUserService userService,
            ICardService cardService,
            ModelMapper modelMapper,
            Environment env,
            RestTemplate restTemplate
    ) {
        this.transferBalanceRepository = transferBalanceRepository;
        this.currencyService = currencyService;
        this.cardService = cardService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.env = env;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public void transferMoney(CardRequestDto cardRequestDto/*, UserTransferLogDto userTransferLogDto, String destinationCardNumber, Integer secondPassword*/) {

        //get default currency from env
//        CurrencyDto currencyDto = currencyService.findByDescriptor(env.getProperty("currency_descriptor"));
//        Currency currency = modelMapper.map(currencyDto, Currency.class);

        //load current user (source)
        UserDto currentUserDto = userService.loadCurrentUser();
        User currentUser = modelMapper.map(currentUserDto, User.class);

//        CardDto sourceCardDto = cardService.findByCardNumber(cardRequestDto.getCardNumber());
        // find source card object by userId and cardNumber
        CardDto sourceCardDto = cardService.findByUserIdByCardNumber(currentUser.getId(), cardRequestDto.getCardNumber());
        Card card = modelMapper.map(sourceCardDto, Card.class);

        //check source card number and destination card number doesn't simple
        if (card.getCardNumber().equals(cardRequestDto.getDestinationCardNumber())) {
            //todo: create record for transfer report
//            transferReportService.createTransferReport();
            throw new NotFoundException("Not Found The entered card number does not match the name of the desired card number", 404);
        }

        // check card balances is != 0 by userId
        if (card.getBalance().compareTo(cardRequestDto.getAmount()) < 0) {
            //todo: create record for transfer report
            throw new OverDraftException("Account with id:" + card.getId() + " does not have enough balance to transfer.", 401, HttpStatus.CONFLICT);
        }

        //find destination cardNumber
        CardDto destinationCardDto = cardService.findByCardNumber(cardRequestDto.getDestinationCardNumber());
        Card destinationCard = modelMapper.map(destinationCardDto, Card.class);

        //we should reduce the source card balance
        sourceCardDto.setBalance(card.getBalance() - cardRequestDto.getAmount());
        cardService.update(sourceCardDto.getId(), sourceCardDto);

        //create transfer log for every reduce or increase
        TransferBalanceDto transferBalanceWithdrawDto = this.createTransferBalance(sourceCardDto, cardRequestDto, true);

        //we should increase the destination card balance
        destinationCardDto.setBalance(destinationCard.getBalance() + cardRequestDto.getAmount());
        cardService.update(destinationCardDto.getId(), destinationCardDto);

        //create transfer log for every reduce or increase
        this.createTransferBalance(destinationCardDto, cardRequestDto, false);

        //todo: 4-2: send notification (sms)

        //fill request body for send email
        /*EmailRequestDto emailRequestDto = new EmailRequestDto(
                "transfer was successfully. " + "\n"
                        + "withdraw: " + transferBalanceWithdrawDto.getWithdraw() + "\n"
                        + "balance: " + transferBalanceWithdrawDto.getBalance() + "\n"
                        + "current time: " + Timestamp.valueOf(LocalDateTime.now()),

                env.getProperty("sender_email"),
                "Transfer Notification",
                currentUserDto.getEmail());

        //set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<Object>(emailRequestDto, headers);

        //call rest for send email
        restTemplate.postForObject(emailResource, entity, String.class);*/

        /*-------------------------------------------------------------------------------------------*/

        //fill request body for send sms
        SmsRequestDto smsRequestDto = new SmsRequestDto(
                currentUser.getMobile(),
                "transfer was successfully " + "\n"
                        + "withdraw: " + transferBalanceWithdrawDto.getWithdraw() + "\n"
                        + "balance: " + transferBalanceWithdrawDto.getBalance() + "\n"
                        + "current time: " + Timestamp.valueOf(LocalDateTime.now())
        );

        //set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<Object>(smsRequestDto, headers);

        //call rest for send sms
        restTemplate.postForObject(smsResource, entity, String.class);
    }

    @Override
    public TransferBalanceDto createTransferBalance(CardDto cardDto, CardRequestDto cardRequestDto, Boolean withdraw) {

        Card card = modelMapper.map(cardDto, Card.class);

        TransferBalance transferBalance = new TransferBalance();
        transferBalance.setCard(card);
        transferBalance.setBalance(card.getBalance());

        if (withdraw) {
            transferBalance.setWithdraw(cardRequestDto.getAmount());
            transferBalance.setDeposit(null);

        } else {
            transferBalance.setWithdraw(null);
            transferBalance.setDeposit(cardRequestDto.getAmount());
        }

        transferBalance.setDestinationCardNumber(cardRequestDto.getDestinationCardNumber());
        transferBalance.setTrackingCode(String.valueOf(Math.random()));
        transferBalance.setTransferAmount(cardRequestDto.getAmount());
        TransferBalance transferBalanceEntity = transferBalanceRepository.save(transferBalance);

        // convert entity to DTO
        return modelMapper.map(transferBalanceEntity, TransferBalanceDto.class);
    }
}
