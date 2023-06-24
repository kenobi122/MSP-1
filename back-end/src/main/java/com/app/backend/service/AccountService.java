package com.app.backend.service;


import java.util.List;

import com.app.backend.model.common.ResponseWrapper;
import com.app.backend.model.entity.Account;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;


public interface AccountService {
    List<Account> getList();
    ResponseWrapper<String> create(AccountRegister register);
    ResponseWrapper<String>  login(LoginRequest request);
    
}
