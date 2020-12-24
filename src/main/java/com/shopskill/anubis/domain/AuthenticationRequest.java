package com.shopskill.anubis.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthenticationRequest {

    @NotNull(message = "Please provide valid username !")
    private String userName;

    @NotNull(message = "Please provide valid password !")
    private String password;

}
