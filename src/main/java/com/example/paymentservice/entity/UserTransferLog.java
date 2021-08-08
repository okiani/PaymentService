package com.example.paymentservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "USER_TRANSFER_LOGS")
public class UserTransferLog {

    @Id
    @GeneratedValue
    private Long id;
    private String destinationCardNumber;
    private Double price;
    private String trackingCode;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Card card;
}

