package com.app.backend.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountRegister {
    @NotBlank
    private String accountName;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    private int age;
    
}
