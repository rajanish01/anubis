package com.shopskill.anubis.domain;

import com.shopskill.anubis.enums.UserCategory;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserMapping {

    @NotEmpty(message = "First Name Can Not Be Empty Or Null !")
    private String firstName;
    private String lastName = "";

    @NotEmpty(message = "Password Can Not Be Empty Or Null !")
    private String password;

    //    @EnumValidator(enumClazz = UserCategory.class)
    private UserCategory userCategory;

}
