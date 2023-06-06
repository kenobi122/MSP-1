package com.app.backend.model.common;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorCode {
    private LocalDateTime createTime;
    private HttpStatus statusCode;
    private String message;
    
    public ErrorCode(HttpStatus statusCode, String message){
        this.createTime = LocalDateTime.now();
        this.statusCode = statusCode;
        this.message = message;
    }
}
