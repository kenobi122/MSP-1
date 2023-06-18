package com.app.backend.model.common;

import lombok.Data;

@Data
public class FieldViolation {

    private String fieldName;
    private String cause;

    public FieldViolation(String fieldName, String cause) {
        this.cause = cause;
        this.fieldName = fieldName;
    }
}
