package com.example.paymentservice.repository;

import com.example.paymentservice.dto.CardNumberDto;
import com.example.paymentservice.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByCardNumber(String cardNumber);

    Optional<Card> findByUserId(Long userId);

    @Query("select c from Card c " +
            "where  c.user.id = :userId " +
            "AND c.cardNumber = :cardNumber " +
            "AND c.expiredDate >= current_timestamp " +
            "and c.status = true ")
    Optional<Card> findByUserIdByCardNumber(@Param("userId") Long userId, @Param("cardNumber")  String cardNumber);

    @Query("select c from Card c where c.expiredDate >= current_date and c.status = true")
    List<Card> getAllCardNumber();
}
