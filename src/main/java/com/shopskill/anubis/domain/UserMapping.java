package com.shopskill.anubis.domain;

import com.shopskill.anubis.enums.UserCategory;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserMapping {

    @NotEmpty(message = "User Name Can Not Be Empty Or Null !")
    private String userName;

    @NotEmpty(message = "Password Can Not Be Empty Or Null !")
    private String password;

    //    @EnumValidator(enumClazz = UserCategory.class)
    private UserCategory userCategory;

}
