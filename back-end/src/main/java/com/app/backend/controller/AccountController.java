package com.app.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.backend.model.common.Response;
import com.app.backend.model.request.AccountRegister;
import com.service.AccountService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @PostMapping("/register")
    public ResponseEntity<String> getMethodName(@RequestBody AccountRegister accountRegister) {
        return Response.ok(HttpStatus.OK, service.create(accountRegister));
    }

}
