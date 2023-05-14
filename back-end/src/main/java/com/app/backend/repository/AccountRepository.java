package com.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.backend.model.entity.Account;

@org.springframework.stereotype.Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
