package com.example.paymentservice.repository;

import com.example.paymentservice.entity.TransferBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITransferBalanceRepository extends JpaRepository<TransferBalance, Long> {

}
