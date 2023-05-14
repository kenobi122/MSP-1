package com.service.impl;

import org.springframework.stereotype.Service;

import com.app.backend.model.entity.Account;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.repository.AccountRepository;
import com.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Override
    public String create(AccountRegister register) {
        Account account = new Account();
        account.setAccountName(register.getAccountName());
        account.setAge(register.getAge());
        account.setPassword(register.getPassword());
        account.setEmail(register.getEmail());

        repository.save(account);
        return account.getAccountName();
    }

}
