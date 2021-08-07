package com.example.paymentservice.service.Impl;

import com.example.paymentservice.repository.IUserTransferLogRepository;
import com.example.paymentservice.service.IUserTransferLogService;
import org.springframework.stereotype.Service;


@Service
public class UserTransferLogServiceImpl implements IUserTransferLogService {

    private final IUserTransferLogRepository userTransferLogRepository;

    public UserTransferLogServiceImpl(
            IUserTransferLogRepository userTransferLogRepository
    ) {
        this.userTransferLogRepository = userTransferLogRepository;
    }
}
