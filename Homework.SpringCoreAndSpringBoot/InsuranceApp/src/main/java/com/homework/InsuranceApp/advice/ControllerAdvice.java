package com.homework.InsuranceApp.advice;

import com.homework.InsuranceApp.exception.InsuranceNotFoundException;
import com.homework.InsuranceApp.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String methodArgumentException(UserNotFoundException exception){
        log.debug(exception.getMessage());
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InsuranceNotFoundException.class)
    public String methodArgumentException(InsuranceNotFoundException exception){
        log.debug(exception.getMessage());
        return exception.getMessage();
    }


}
