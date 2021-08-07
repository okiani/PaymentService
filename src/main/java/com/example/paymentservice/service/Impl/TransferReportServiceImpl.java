package com.example.paymentservice.service.Impl;

import com.example.paymentservice.repository.ITransferReportRepository;
import com.example.paymentservice.service.IUserTransferLogService;
import org.springframework.stereotype.Service;


@Service
public class TransferReportServiceImpl implements IUserTransferLogService {

    private final ITransferReportRepository transferReportRepository;

    public TransferReportServiceImpl(
            ITransferReportRepository transferReportRepository
    ) {
        this.transferReportRepository = transferReportRepository;
    }
}
