package com.example.paymentservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "CURRENCIES")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @Value("${currency_descriptor}")
    private String descriptor;
    private String sign;
    private Boolean status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
