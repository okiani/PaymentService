package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Getter
@Setter
public class CurrencyDto {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "name cannot be null")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "descriptor cannot be null")
    @JsonProperty("descriptor")
    private String descriptor;

    @NotNull(message = "sign cannot be null")
    @JsonProperty("sign")
    private String sign;

    @AssertTrue
    @JsonProperty("status")
    private Boolean status;
}
