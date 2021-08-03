package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class UserAccountBalanceDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private BigInteger userId;

    @JsonProperty("currency_id")
    private BigInteger currencyId;

    @JsonProperty("account_balance")
    private Double accountBalance;
}
