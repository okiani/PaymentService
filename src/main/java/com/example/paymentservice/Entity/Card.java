package com.example.paymentservice.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "CARDS")
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private User user;

    private String cardNumber;
    private String holderName;
    private String cardType;
    private Date expiredDate;
    private String csv;
    private Double dailyLimit;
    private Boolean status;

    public Card() {
    }
}
