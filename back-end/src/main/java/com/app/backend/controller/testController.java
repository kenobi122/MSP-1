package com.app.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.model.common.Response;
import com.app.backend.model.common.SystemResponse;

@RestController
@RequestMapping("/api")
public class testController {
    @GetMapping("/test")
    public  ResponseEntity<SystemResponse<String>> test() {
        return Response.ok(HttpStatus.OK, new SystemResponse<>("kak"));
    }
}
