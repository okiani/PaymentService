package com.example.paymentservice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @Value("${currency_descriptor}")
    private String descriptor;
    private String sign;
    private Boolean status;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
