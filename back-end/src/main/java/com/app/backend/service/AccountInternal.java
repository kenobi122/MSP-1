package com.app.backend.service;


import com.app.backend.model.entity.Account;
import com.app.backend.model.entity.AccountEmail;
import com.app.backend.model.entity.AccountInfo;
import com.app.backend.model.entity.AccountPassword;

public interface AccountInternal {
    void accountCreateService(Account account, AccountEmail accountEmail, AccountInfo accountInfo, AccountPassword accountPassword);
    AccountPassword accountGetPassword(String accountId);
}
