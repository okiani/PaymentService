package com.example.paymentservice.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String phoneNumber;
    private String mobile;
    private String address;

    @JsonIgnore
    private String password;

    private Timestamp createdAt;
    private Integer status;

    @JsonProperty
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
