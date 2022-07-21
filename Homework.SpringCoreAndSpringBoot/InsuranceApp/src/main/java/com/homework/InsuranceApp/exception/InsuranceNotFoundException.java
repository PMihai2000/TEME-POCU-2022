package com.homework.InsuranceApp.exception;

public class InsuranceNotFoundException extends RuntimeException{
    public InsuranceNotFoundException(String message) {
        super(message);
    }
}
