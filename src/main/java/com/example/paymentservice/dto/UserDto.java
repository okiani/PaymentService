package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Timestamp;

@Getter
@Setter
@Data
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Username cannot be null")
    @JsonProperty("user_name")
    private String username;

    @Email(message = "Email should be valid")
    @NotNull
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @Size(min = 0, max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    @JsonProperty("mobile")
    private String mobile;

    @Size(min = 10, max = 250, message = "Address must be between 10 and 250 characters")
    @JsonProperty("address")
    private String address;

    @NotNull
    @JsonProperty("password")
    @JsonIgnore
    private String password;

    @AssertTrue
    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Timestamp updatedAt;

}
