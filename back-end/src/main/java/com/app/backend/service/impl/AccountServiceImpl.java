package com.app.backend.service.impl;

import com.app.backend.config.JwtProvider;
import com.app.backend.exception.AppException;
import com.app.backend.mapper.AccountMapper;
import com.app.backend.model.common.ResponseWrapper;
import com.app.backend.model.entity.Account;
import com.app.backend.model.entity.AccountEmail;
import com.app.backend.model.entity.AccountInfo;
import com.app.backend.model.entity.AccountPassword;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;
import com.app.backend.repository.AccountRepository;
import com.app.backend.service.AccountInternal;
import com.app.backend.service.AccountService;
import com.app.backend.ulti.BusinessErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AccountInternal accountInternal;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public ResponseWrapper<String> create(AccountRegister register) {

        if (repository.existsByUsername(register.getUsername())) {
            throw new AppException(BusinessErrorCode.ACCOUNT_ALREADY_EXIST);
        }

        Account account = accountMapper.from(register);

        repository.save(account);

        AccountEmail accountEmail = accountMapper.fromEmail(register);
        accountEmail.setAccountId(account.getAccoundId());

        AccountInfo accountInfo = accountMapper.fromInfo(register);
        accountInfo.setAccountId(account.getAccoundId());

        AccountPassword accountPassword = new AccountPassword();
        accountPassword.setAccountId(account.getAccoundId());
        accountPassword.setPassword(passwordEncoder.encode(register.getPassword()));

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
