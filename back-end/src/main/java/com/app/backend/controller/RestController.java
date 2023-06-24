package com.app.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.app.backend.model.common.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.backend.exception.AppException;
import com.app.backend.model.common.ErrorCode;
import com.app.backend.model.common.FieldViolation;
import com.app.backend.model.common.Response;

@RestControllerAdvice
public class RestController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper> commonException(Exception ex) {

        return ResponseEntity.internalServerError()
                .body(ResponseWrapper.Fail(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorCode> handleInvalidException(MethodArgumentNotValidException ex) {

        List<FieldViolation> fieldViolations = ex.getBindingResult().getAllErrors()
                .stream().map(error -> new FieldViolation(((FieldError) error).getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        return Response.fail(new ErrorCode(HttpStatus.BAD_GATEWAY, fieldViolations));
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ResponseWrapper> appExceptionHandler(AppException ex) {
        return ResponseEntity.status(ex.getErrorcode().getStatusCode()).body(ResponseWrapper.FailOf(ex.getErrorcode()));
    }

}
