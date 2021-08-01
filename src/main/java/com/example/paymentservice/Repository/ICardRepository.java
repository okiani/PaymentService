package com.example.paymentservice.Repository;

import com.example.paymentservice.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICardRepository extends JpaRepository<Card, Integer> {

    List<Card> findAll();

    Card findById(Long id);

    Card findByCardNumber(String cardNumber);

    void deleteById(Long id);
}
