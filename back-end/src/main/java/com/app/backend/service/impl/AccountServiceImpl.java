package com.app.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.backend.config.JwtProvider;
import com.app.backend.exception.AppException;
import com.app.backend.model.entity.Account;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;
import com.app.backend.model.response.AccountReponse;
import com.app.backend.repository.AccountRepository;
import com.app.backend.service.AccountService;
import com.app.backend.ulti.BusinessErrorCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final JwtProvider jwtProvider;

    @Override
    public List<Account> getList() {
        return repository.findAll();
    }

    @Override
    public String create(AccountRegister register) {
        Account account = new Account();

        account.setUsername(register.getUsername());
        account.setAge(register.getAge());
        account.setPassword(register.getPassword());
        account.setEmail(register.getEmail());

        if (repository.existsByUsername(account.getUsername())) {
            throw new AppException(BusinessErrorCode.ACCOUNT_ALREADY_EXIST);
        }
        
        repository.save(account);
        return account.getUsername();
    }

    @Override
    public String login(LoginRequest request) {
        Account account = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(BusinessErrorCode.ACCOUNT_NOT_FOUND));

        if (!account.getPassword().equals(request.getPassword())) {
            throw new AppException(BusinessErrorCode.PASSWORD_WRONG);
        }
        

        return jwtProvider.doGenerateJwt(account.getUsername());
    }

   

}
