package com.example.paymentservice.service.Impl;

import com.example.paymentservice.dto.TransferReportDto;
import com.example.paymentservice.entity.TransferReport;
import com.example.paymentservice.entity.UserTransferLog;
import com.example.paymentservice.repository.ITransferReportRepository;
import com.example.paymentservice.service.ITransferReportService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class TransferReportServiceImpl implements ITransferReportService {

    private final ITransferReportRepository transferReportRepository;
    private ModelMapper modelMapper;

    public TransferReportServiceImpl(
            ITransferReportRepository transferReportRepository,
            ModelMapper modelMapper
    ) {
        this.transferReportRepository = transferReportRepository;
        this.modelMapper = modelMapper;
    }

    /*@Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TransferReportDto createTransferReport(UserTransferLog userTransferLog, String message, Boolean status) {
        return this._createTransferReport(userTransferLog, message, status);
    }

    public TransferReportDto createTransferReportasdasdasdasd(UserTransferLog userTransferLog, String message, Boolean status) {
        return this._createTransferReport(userTransferLog, message, status);
    }*/

    public TransferReportDto createTransferReport(UserTransferLog userTransferLog, String message, Boolean status) {
        TransferReport transferReport = new TransferReport();
        transferReport.setUserTransferLog(userTransferLog);
        transferReport.setMessage(message);
        transferReport.setSuccess(status);
        TransferReport transferReportEntity = transferReportRepository.save(transferReport);

        // convert entity to DTO
        return modelMapper.map(transferReportEntity, TransferReportDto.class);
    }
}
