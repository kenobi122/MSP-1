package com.app.backend.model.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {


    public static <T> ResponseEntity<T> ok(HttpStatus status, T body) {
        return ResponseEntity.status(status).body(body);
    }

    public static <T> ResponseEntity<T> fail(T body) {
        return ResponseEntity.status(((ErrorCode) body).getStatusCode()).body(body);
    }

}
