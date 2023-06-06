package com.app.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.backend.exception.AppException;
import com.app.backend.model.common.ErrorCode;
import com.app.backend.ulti.BusinessException;

@RestControllerAdvice
public class RestController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCode> commonException(Exception ex) {

        return ResponseEntity.status(BusinessException.COMMON_EXCEPTION.getStatusCode())
                .body(BusinessException.COMMON_EXCEPTION);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorCode> appExceptionHandler(AppException ex) {
        return ResponseEntity.status(ex.getErrorcode().getStatusCode()).body(ex.getErrorcode());
    }
}
