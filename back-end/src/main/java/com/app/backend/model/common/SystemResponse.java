package com.app.backend.model.common;

import java.time.LocalDateTime;

public class SystemResponse<T> {

    private LocalDateTime createAt;

    private T data;

    public SystemResponse(T data) {
        this.createAt = LocalDateTime.now();
        this.data = data;
    }

}
