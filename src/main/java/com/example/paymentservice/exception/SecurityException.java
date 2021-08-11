package com.example.paymentservice.exception;

public class SecurityException extends BusinessException {

    public SecurityException(String message, int errorCode) {
        super(message, errorCode);
    }
}
