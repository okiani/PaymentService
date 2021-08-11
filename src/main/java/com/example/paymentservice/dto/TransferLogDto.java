package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TransferLogDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("card_id")
    private Long cardId;

//    @DecimalMin("0.0")
    @JsonProperty("balance")
    private Double balance;

    @JsonProperty("deposit")
    private Double deposit;

    @JsonProperty("withdraw")
    private Double withdraw;

    @JsonProperty("transfer_amount")
    private Double transferAmount;

    //todo: must be implement best practice validation
    @JsonProperty("destination_card_number")
    private String destinationCardNumber;

    @Size(min = 16, max = 24)
    @JsonProperty("tracking_code")
    private String trackingCode;
}
