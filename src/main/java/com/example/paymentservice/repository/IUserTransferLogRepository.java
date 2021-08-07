package com.example.paymentservice.repository;

import com.example.paymentservice.entity.Currency;
import com.example.paymentservice.entity.UserTransferLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserTransferLogRepository extends JpaRepository<UserTransferLog, Long> {

}
