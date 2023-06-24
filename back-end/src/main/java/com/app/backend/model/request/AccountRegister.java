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
    @NotBlank(message = "{name.notempty}")
    private String name;

    private String surname;

    private String identityCard;

    private int age;

}
