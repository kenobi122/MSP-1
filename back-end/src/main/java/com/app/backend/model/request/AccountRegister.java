package com.app.backend.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountRegister {
    @NotBlank(message = "{username.notempty}")
    private String username;
    @NotBlank(message = "{password.notempty}")
    private String password;
    @NotBlank(message = "{email.notempty}")
    private String email;
    @NotNull(message = "{age.notempty}")
    private int age;

}
