package com.app.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.backend.model.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
 Optional<Account> findByUsername(String username);
 Boolean existsByUsername(String username);
}
