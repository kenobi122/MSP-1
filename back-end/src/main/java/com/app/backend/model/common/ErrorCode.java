package com.app.backend.model.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

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
