package com.ethan.backend.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ethan.backend.dtos.ExceptionDto;
import com.ethan.backend.exceptions.AppException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ExceptionDto> handleException(AppException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(new ExceptionDto(ex.getMessage()));
    }
}