package com.example.paymentservice.repository;

import com.example.paymentservice.entity.TransferLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITransferLogRepository extends JpaRepository<TransferLog, Long> {

}
