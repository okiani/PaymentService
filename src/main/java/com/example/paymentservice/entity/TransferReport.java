package com.example.paymentservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Setter
@Getter
@Table(name = "transfer_reports")
public class TransferReport {

    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private Boolean success;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserTransferLog userTransferLog;
}

