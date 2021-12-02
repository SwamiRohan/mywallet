package com.example.mywallet.mywalletdemo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;


public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message){
        super(message);
    }
}
