package com.example.paymentservice.repository;

import com.example.paymentservice.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ICurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByDescriptor(String descriptor);

    void deleteById(Long id);
}
