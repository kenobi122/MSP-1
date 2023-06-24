package com.app.backend.repository;

import com.app.backend.model.entity.Account;
import com.app.backend.model.entity.AccountEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountEmailRepository extends JpaRepository<AccountEmail, Long> {
}
