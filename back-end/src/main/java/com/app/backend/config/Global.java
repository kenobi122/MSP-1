package com.app.backend.config;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Global {
    private Map<String, String> roleMap;

    public Global(Map<String, String> roleMap) {
        this.roleMap = roleMap;
    }
}
