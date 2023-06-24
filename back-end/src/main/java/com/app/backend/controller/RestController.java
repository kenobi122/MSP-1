package com.app.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.app.backend.model.common.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.backend.exception.AppException;
import com.app.backend.model.common.FieldViolation;

@RestControllerAdvice
public class RestController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<String>> commonException(Exception ex) {

        return ResponseEntity.internalServerError()
                .body(ResponseWrapper.Fail(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWrapper<List<FieldViolation>>> handleInvalidException(MethodArgumentNotValidException ex) {

        List<FieldViolation> fieldViolations = ex.getBindingResult().getAllErrors()
                .stream().map(error -> new FieldViolation(((FieldError) error).getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(400).body(ResponseWrapper.FailOf(fieldViolations));
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ResponseWrapper<String>> appExceptionHandler(AppException ex) {
        return ResponseEntity.status(ex.getErrorcode().getStatusCode())
                .body(ResponseWrapper.FailOf(ex.getErrorcode()));
    }

}
