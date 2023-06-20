package com.app.backend.service;


import java.util.List;

import com.app.backend.model.entity.Account;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;


public interface AccountService {
    public List<Account> getList();
    public String create(AccountRegister register);
    public String login(LoginRequest request);
    
}
