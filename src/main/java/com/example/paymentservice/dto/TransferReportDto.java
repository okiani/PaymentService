package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class TransferReportDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_transfer_log_id")
    private BigInteger userTransferLogId;

    @JsonProperty("message")
    private String message;

    @JsonProperty("success")
    private Boolean success;
}
