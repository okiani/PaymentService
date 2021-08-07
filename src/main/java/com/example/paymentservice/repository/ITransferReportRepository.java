package com.example.paymentservice.repository;

import com.example.paymentservice.entity.TransferReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITransferReportRepository extends JpaRepository<TransferReport, Long> {

}
