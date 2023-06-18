package com.app.backend.model.common;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorCode<T> {
    private LocalDateTime createTime;
    private HttpStatus statusCode;
    private String message;
    private List<FieldViolation> fieldViolations;

    public ErrorCode(HttpStatus statusCode, String message) {
        this.createTime = LocalDateTime.now();
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorCode(HttpStatus statusCode, List<FieldViolation> fieldViolations) {
        this.createTime = LocalDateTime.now();
        this.statusCode = statusCode;
        this.fieldViolations = fieldViolations;
    }
}
