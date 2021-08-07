package com.example.paymentservice.controller;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.service.IUserAccountBalanceService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("api/v1/account")
public class AccountController {

    IUserAccountBalanceService userAccountBalanceService;

    public AccountController(IUserAccountBalanceService userAccountBalanceService) {
        this.userAccountBalanceService = userAccountBalanceService;
    }

    @PostMapping("/transfer-money")
    public String transferMoney(/*@RequestBody CardDto cardDto*/) {

        //todo: in request body we need user transfer log fields (destination card number & price)

        return userAccountBalanceService.transferMoney();
    }
}
