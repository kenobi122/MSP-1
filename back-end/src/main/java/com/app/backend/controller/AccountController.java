package com.app.backend.controller;

import com.app.backend.model.common.ResponseWrapper;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;
import com.app.backend.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseWrapper> createController(@RequestBody @Valid AccountRegister accountRegister) {
        return ResponseEntity.status(201).body(service.create(accountRegister));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseWrapper<String>> loginController(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.status(200).body(service.login(request));
    }
}
