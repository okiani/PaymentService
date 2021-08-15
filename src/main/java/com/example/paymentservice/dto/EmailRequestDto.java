package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@Data
public class EmailRequestDto {

    @JsonProperty("body")
    private String body;

    @JsonProperty("from")
    private String from;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("to")
    private String to;

    @JsonCreator
    public EmailRequestDto(String body, String from, String subject, String to) {
        this.body = body;
        this.from = from;
        this.subject = subject;
        this.to = to;
    }
}
