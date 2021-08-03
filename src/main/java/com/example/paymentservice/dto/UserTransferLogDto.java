package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Date;

@Getter
@Setter
public class UserTransferLogDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private BigInteger userId;

    @JsonProperty("card_id")
    private BigInteger cardId;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("destination_card_number")
    private String destinationCardNumber;

    @JsonProperty("tracking_code")
    private String trackingCode;
}
