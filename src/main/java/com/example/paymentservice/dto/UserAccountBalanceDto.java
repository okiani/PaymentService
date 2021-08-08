package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;

@Data
@Getter
@Setter
public class UserAccountBalanceDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("currency_id")
    private Long currencyId;

    @DecimalMin("0.0")
    @JsonProperty("account_balance")
    private Double accountBalance;
}
