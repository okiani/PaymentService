package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class CardNumberDto {

    @JsonProperty("id")
    private Long id;

    //todo: must be implement best practice validation
    @JsonProperty("card_number")
    private String cardNumber;
}
