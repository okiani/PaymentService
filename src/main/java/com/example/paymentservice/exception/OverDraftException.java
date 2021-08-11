package com.example.paymentservice.exception;

import org.springframework.http.HttpStatus;

public class OverDraftException extends BusinessException {

    public OverDraftException(String message, int errorCode) {
        super(message, errorCode);
    }

    public OverDraftException(String message, int errorCode, HttpStatus httpStatus) {
        super(message, errorCode);
    }
}
