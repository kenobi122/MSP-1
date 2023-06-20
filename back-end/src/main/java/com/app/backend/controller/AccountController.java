package com.app.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.model.common.Response;
import com.app.backend.model.entity.Account;
import com.app.backend.model.request.AccountRegister;
import com.app.backend.model.request.LoginRequest;
import com.app.backend.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service){
        this.service = service;
    }

    @GetMapping("/getAccountList")
    public ResponseEntity<List<Account>> getAccountList() {
        return Response.ok(HttpStatus.OK, service.getList());
    }
 
    @PostMapping("/register")
    public ResponseEntity<String> createController(@RequestBody @Valid AccountRegister accountRegister) {
        return Response.ok(HttpStatus.OK, service.create(accountRegister));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginController(@RequestBody @Valid LoginRequest request) {
        return Response.ok(HttpStatus.OK, service.login(request));
    }
}
