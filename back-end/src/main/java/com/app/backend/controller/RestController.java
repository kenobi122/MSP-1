package com.app.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.backend.model.common.ErrorCode;
import com.app.backend.ulti.AppException;

@RestControllerAdvice
public class RestController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCode> commonException(Exception ex) {
        ErrorCode errorCode = new ErrorCode();
        errorCode.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorCode);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorCode> appExceptionHandler(AppException ex) {
        return ResponseEntity.status(ex.getErrorcode().getStatusCode()).body(ex.getErrorcode());
    }
}
