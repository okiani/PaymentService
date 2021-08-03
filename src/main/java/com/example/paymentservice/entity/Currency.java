package com.example.paymentservice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private String description;
    private String sign;
    private Boolean status;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
