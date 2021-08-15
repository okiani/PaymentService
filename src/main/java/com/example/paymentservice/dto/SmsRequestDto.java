package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@Data
public class SmsRequestDto {

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("text")
    private String text;

    @JsonProperty("balance")
    private Double balance;

    @JsonProperty("withdraw")
    private Double withdraw;

    @JsonProperty("current_date")
    private Timestamp currentDate;

    @JsonCreator
    public SmsRequestDto(
            String mobile,
            String text
//            Double balance,
//            Double withdraw,
//            Timestamp currentDate
            ) {
        this.mobile = mobile;
        this.text = text;
//        this.balance = balance;
//        this.withdraw = withdraw;
//        this.currentDate = currentDate;
    }
}
