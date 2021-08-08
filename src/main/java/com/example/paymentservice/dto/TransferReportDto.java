package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import java.math.BigInteger;

@Getter
@Setter
public class TransferReportDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_transfer_log_id")
    private Long userTransferLogId;

    @JsonProperty("message")
    private String message;

    @AssertTrue
    @JsonProperty("success")
    private Boolean success;
}
