package com.example.paymentservice.service;

import com.example.paymentservice.dto.CurrencyDto;

import java.util.List;

public interface ICurrencyService {

    List<CurrencyDto> findAll();

    CurrencyDto save(CurrencyDto CurrencyDto);

    CurrencyDto update(Long id, CurrencyDto CurrencyDto);

    void delete(Long id);

    CurrencyDto findById(Long id);
}
