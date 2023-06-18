package com.app.backend.ulti;

import org.springframework.http.HttpStatus;

import com.app.backend.model.common.ErrorCode;

public class BusinessErrorCode {
    public static ErrorCode COMMON_EXCEPTION =  new ErrorCode(HttpStatus.INTERNAL_SERVER_ERROR , "Something wrong");
    public static ErrorCode ACCOUNT_NOT_FOUND =  new ErrorCode(HttpStatus.BAD_REQUEST , "account not found");
    public static ErrorCode ACCOUNT_ALREADY_EXIST =  new ErrorCode(HttpStatus.BAD_REQUEST , "account already exist");
    public static ErrorCode PASSWORD_WRONG =  new ErrorCode(HttpStatus.BAD_REQUEST , "wrong password");
    public static ErrorCode IVALID_TOKEN =  new ErrorCode(HttpStatus.BAD_REQUEST , "invalid token");
    public static ErrorCode JSONB_EXCEPTION =  new ErrorCode(HttpStatus.BAD_REQUEST , "input cant be null");

}
