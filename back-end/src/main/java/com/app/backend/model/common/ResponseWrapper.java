package com.app.backend.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ResponseWrapper<T> {
//    @JsonProperty("body")
    private T body;
//    @JsonProperty("status")
    private String status;
//    @JsonProperty("cause")
    private String cause;

    public static <T> ResponseWrapper Succeed(T body) {
        ResponseWrapper<T> responseBody = new ResponseWrapper<>();
        responseBody.body = body;
        responseBody.status = "success";
        return responseBody;
    }

    public static <T> ResponseWrapper Succeed() {
        ResponseWrapper<T> responseBody = new ResponseWrapper<>();
        responseBody.body = null;
        responseBody.status = "success";
        return responseBody;
    }

    public static <T> ResponseWrapper FailOf(T body) {
        ResponseWrapper<T> responseBody = new ResponseWrapper<>();
        responseBody.body = body;
        responseBody.status = "error";
        return responseBody;
    }

    public static <T> ResponseWrapper Fail(String cause) {
        ResponseWrapper<T> responseBody = new ResponseWrapper<>();
        responseBody.status = "error";
        responseBody.cause = cause;
        return responseBody;
    }

}
