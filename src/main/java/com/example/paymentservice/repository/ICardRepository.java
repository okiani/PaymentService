package com.example.paymentservice.repository;

import com.example.paymentservice.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {

//    List<Card> findAll();

//    Card findById(Long id);

//    Card findByCardNumber(String cardNumber);
    Optional<Card> findByCardNumber(String cardNumber);

    void deleteById(Long id);
}
