package com.example.paymentservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "TRANSFER_BALANCES")
public class TransferBalance {

    @Id
    @GeneratedValue
    private Long id;
    private Double balance;
    private Double transferAmount;
    private Double withdraw;
    private Double deposit;
    private String destinationCardNumber;
    private String trackingCode;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Card card;

    /*@Override
    public String toString() {
        return String.format("Card[id=%d, cardNumber='%s', holderName='%s', cardType='%s']", id, cardNumber, holderName, cardType);
    }*/
}
