package com.app.backend.ulti;

import com.app.backend.model.common.ErrorCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorCode errorcode;

    public AppException(String msg, ErrorCode errorcode) {
        super(msg);
        this.errorcode = errorcode;

    }

}
