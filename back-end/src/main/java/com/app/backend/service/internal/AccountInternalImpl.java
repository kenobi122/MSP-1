package com.app.backend.service.internal;

import com.app.backend.exception.AppException;
import com.app.backend.model.entity.Account;
import com.app.backend.model.entity.AccountEmail;
import com.app.backend.model.entity.AccountInfo;
import com.app.backend.model.entity.AccountPassword;
import com.app.backend.repository.AccountEmailRepository;
import com.app.backend.repository.AccountInfoRepository;
import com.app.backend.repository.AccountPasswordRepository;
import com.app.backend.repository.AccountRepository;
import com.app.backend.service.AccountInternal;
import com.app.backend.ulti.BusinessErrorCode;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountInternalImpl implements AccountInternal {
    private final AccountRepository accountRepository;
    private final AccountPasswordRepository accountPasswordRepository;
    private final AccountEmailRepository accountEmailRepository;
    private final AccountInfoRepository accountInfoRepository;

    @Override
    public void accountCreateService(Account account, AccountEmail accountEmail, AccountInfo accountInfo, AccountPassword accountPassword) {
//        accountRepository.save(account);
        accountEmailRepository.save(accountEmail);
        accountInfoRepository.save(accountInfo);
        accountPasswordRepository.save(accountPassword);
    }

    @Override
    public AccountPassword accountGetPassword(String accountId) {
        return accountPasswordRepository.findByAccountId(accountId).orElseThrow(()
                -> new AppException(BusinessErrorCode.COMMON_EXCEPTION));

    }
}
