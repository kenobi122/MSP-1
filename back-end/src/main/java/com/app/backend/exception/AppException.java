package com.app.backend.exception;

import com.app.backend.model.common.ErrorCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorCode errorcode;

    public AppException(ErrorCode errorcode) {
        this.errorcode = errorcode;
    }

}
