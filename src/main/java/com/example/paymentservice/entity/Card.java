package com.example.paymentservice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "CARDS")
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private String cardNumber;
    private String holderName;
    private String cardType;
    private Integer cvv2;
    private Date expiredDate;
    private Double dailyLimit;
    private Boolean status;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;*/

    @Override
    public String toString() {
        return String.format("Card[id=%d, cardNumber='%s', holderName='%s', cardType='%s']", id, cardNumber, holderName, cardType);
    }
}
