package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.sql.Date;

@Getter
@Setter
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_name")
    private String username;

    @Email
    @NotNull
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("address")
    private String address;

    @NotNull
    @JsonProperty("password")
    private String password;

    @JsonProperty("status")
    private Boolean status;

}
