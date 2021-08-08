package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.sql.Date;

@Getter
@Setter
public class UserTransferLogDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("card_id")
    private Long cardId;

    @DecimalMin("0.0")
    @JsonProperty("price")
    private Double price;

    //todo: must be implement best practice validation
    @JsonProperty("destination_card_number")
    private String destinationCardNumber;

    @Size(min = 16, max = 24)
    @JsonProperty("tracking_code")
    private String trackingCode;
}
