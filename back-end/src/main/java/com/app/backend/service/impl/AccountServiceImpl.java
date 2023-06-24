package com.app.backend.service.impl;

import java.util.List;

import com.app.backend.model.common.ResponseWrapper;
import com.app.backend.model.entity.AccountEmail;
import com.app.backend.model.entity.AccountInfo;
import com.app.backend.model.entity.AccountPassword;
import com.app.backend.service.AccountInternal;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.backend.config.JwtProvider;
import com.app.backend.exception.AppException;
import com.app.backend.model.entity.Account;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;
import com.app.backend.repository.AccountRepository;
import com.app.backend.service.AccountService;
import com.app.backend.ulti.BusinessErrorCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AccountInternal accountInternal;

    @Override
    public List<Account> getList() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public ResponseWrapper<String> create(AccountRegister register) {

        if (repository.existsByUsername(register.getUsername())) {
            throw new AppException(BusinessErrorCode.ACCOUNT_ALREADY_EXIST);
        }


        Account account = new Account();
        account.setUsername(register.getUsername());

        repository.save(account);

        AccountEmail accountEmail = new AccountEmail();
        accountEmail.setAccountId(account.getAccoundId());
        accountEmail.setEmail(register.getEmail());
        accountEmail.setDelFlg(Boolean.FALSE);

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountId(account.getAccoundId());
        accountInfo.setAge(register.getAge());
        accountInfo.setName(register.getName());
        accountInfo.setSurname(register.getSurname());

        AccountPassword accountPassword = new AccountPassword();
        accountPassword.setAccountId(account.getAccoundId());
        accountPassword.setPassword(passwordEncoder.encode(register.getPassword()));
        accountPassword.setDelFlg(Boolean.FALSE);

        accountInternal.accountCreateService(account, accountEmail, accountInfo, accountPassword);
        return ResponseWrapper.Succeed(account.getUsername());
    }

    @Override
    public ResponseWrapper<String> login(LoginRequest request) {
        Account account = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(BusinessErrorCode.ACCOUNT_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), accountInternal.accountGetPassword(account.getAccoundId()).getPassword())) {
            throw new AppException(BusinessErrorCode.PASSWORD_WRONG);
        }

        return ResponseWrapper.Succeed(jwtProvider.doGenerateJwt(account.getUsername()));
    }

}
