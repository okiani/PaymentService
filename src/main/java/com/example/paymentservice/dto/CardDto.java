package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class CardDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("card_number")
    private String cardNumber;

    @JsonProperty("holder_name")
    private String holderName;

    @JsonProperty("card_type")
    private String cardType;

    @JsonProperty("cvv2")
    private Integer cvv2;

    @JsonProperty("expired_date")
    private Date expiredDate;

    @JsonProperty("status")
    private Boolean status;

    /*@JsonProperty("daily_limit")
    private Double dailyLimit;*/
}
