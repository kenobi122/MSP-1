package com.app.backend.service;


import com.app.backend.model.common.ResponseWrapper;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;


public interface AccountService {
    ResponseWrapper<String> create(AccountRegister register);
    ResponseWrapper<String>  login(LoginRequest request);
    
}
