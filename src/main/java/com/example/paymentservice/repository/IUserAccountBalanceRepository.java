package com.example.paymentservice.repository;

import com.example.paymentservice.entity.UserAccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserAccountBalanceRepository extends JpaRepository<UserAccountBalance, Long> {

    @Query("select id from UserAccountBalance")
    String transferMoney();

    UserAccountBalance findByUserId(Long id);
}
