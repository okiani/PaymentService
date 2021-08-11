package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@Data
public class CardRequestDto {

    @JsonProperty("id")
    private Long id;

    //todo: must be implement best practice validation
    @JsonProperty("card_number")
    private String cardNumber;

    @JsonProperty("destination_card_number")
    private String destinationCardNumber;

    @JsonProperty("second_password")
    private String secondPassword;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("card_type")
    private String cardType;

    @Size(min = 3, max = 5, message = "CVV2 must be between 3 and 5 characters")
    @JsonProperty("cvv2")
    private Integer cvv2;

    @JsonProperty("expired_date")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Timestamp expiredDate;

    @AssertTrue
    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Timestamp updatedAt;

    @JsonProperty("user")
    UserDto userDto;

    /*@JsonProperty("daily_limit")
    private Double dailyLimit;*/
}
