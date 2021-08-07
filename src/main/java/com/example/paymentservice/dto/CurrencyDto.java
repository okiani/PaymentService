package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;

@Getter
@Setter
public class CurrencyDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("descriptor")
    private String descriptor;

    @JsonProperty("sign")
    private String sign;

    @JsonProperty("status")
    private Boolean status;
}
