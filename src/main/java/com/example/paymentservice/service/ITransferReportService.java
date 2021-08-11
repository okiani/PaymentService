package com.example.paymentservice.service;


import com.example.paymentservice.dto.TransferReportDto;
import com.example.paymentservice.entity.UserTransferLog;

public interface ITransferReportService {

    TransferReportDto createTransferReport(UserTransferLog userTransferLog, String message, Boolean status);
}
