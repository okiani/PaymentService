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
public class NotificationRequestDto {

    //sms
    @JsonProperty("body")
    private String body;

    @JsonProperty("from")
    private String from;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("to")
    private String to;


    //email
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
    public NotificationRequestDto(
            String body,
            String from,
            String subject,
            String to,
            String mobile,
            String text
            /*Double balance,
            Double withdraw,
            Timestamp current_date*/
            ) {
        this.body = body;
        this.from = from;
        this.subject = subject;
        this.to = to;
        this.mobile = mobile;
        this.text = text;
        /*this.balance = balance;
        this.withdraw = withdraw;
        this.currentDate = current_date;*/
    }
}
