package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.*;
import com.example.paymentservice.entity.*;
import com.example.paymentservice.exception.NotFoundException;
import com.example.paymentservice.repository.*;
import com.example.paymentservice.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserAccountBalanceServiceImpl implements IUserAccountBalanceService {

    private ModelMapper modelMapper;
    private final IUserAccountBalanceRepository userAccountBalanceRepository;

    public UserAccountBalanceServiceImpl(
            IUserAccountBalanceRepository userAccountBalanceRepository,
            ModelMapper modelMapper
    ) {
        this.userAccountBalanceRepository = userAccountBalanceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserAccountBalanceDto findByUserId(Long userId) {

        Optional<UserAccountBalance> userAccountBalance = userAccountBalanceRepository.findByUserId(userId);
        if (userAccountBalance.isPresent()) {
            // convert entity to DTO
            return modelMapper.map(userAccountBalance.get(), UserAccountBalanceDto.class);
        }
        throw new NotFoundException("Not Found User Account Balance User Id: " + userId, 404);
    }
}
