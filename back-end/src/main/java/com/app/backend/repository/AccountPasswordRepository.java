package com.app.backend.repository;

import com.app.backend.model.entity.AccountPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountPasswordRepository extends JpaRepository<AccountPassword, Long> {
    @Query("select a from account_password a where a.accountId = ?1 and a.delFlg = false ")
    Optional<AccountPassword> findByAccountId(String accountId);
}
