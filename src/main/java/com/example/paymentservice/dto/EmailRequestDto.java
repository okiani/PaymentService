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

    @JsonProperty("channel_type")
    private String channelType;

    @JsonCreator
    public EmailRequestDto(String body, String from, String subject, String to, String channelType) {
        this.body = body;
        this.from = from;
        this.subject = subject;
        this.to = to;
        this.channelType = channelType;
    }
}
