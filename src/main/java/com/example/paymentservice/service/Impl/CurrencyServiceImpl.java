package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.dto.CurrencyDto;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.exception.NotFoundException;
import com.example.paymentservice.repository.ICardRepository;
import com.example.paymentservice.repository.ICurrencyRepository;
import com.example.paymentservice.service.ICardService;
import com.example.paymentservice.service.ICurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements ICurrencyService {

    @Autowired
    private ModelMapper modelMapper;

    private final ICurrencyRepository currencyRepository;

    public CurrencyServiceImpl(ICurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<CurrencyDto> findAll() {

        return currencyRepository.findAll()
                .stream()
                .map(currency -> modelMapper.map(currency, CurrencyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyDto save(CurrencyDto CurrencyDto) {
        return null;
    }

    @Override
    public CurrencyDto update(Long id, CurrencyDto CurrencyDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CurrencyDto findById(Long id) {
        return null;
    }
}
