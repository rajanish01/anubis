package com.shopskill.anubis.domain;

import com.shopskill.anubis.enums.UserCategory;
import com.shopskill.anubis.repository.UserMappingEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserMapping {

    private String userId;

    @NotEmpty(message = "First Name Can Not Be Empty Or Null !")
    private String firstName;
    private String lastName = "";

    @NotEmpty(message = "Password Can Not Be Empty Or Null !")
    private String password;

    //    @EnumValidator(enumClazz = UserCategory.class)
    private UserCategory userCategory;

    public static UserMapping map(UserMappingEntity userMappingEntity) {
        UserMapping userMapping = new UserMapping();
        userMapping.setUserId(userMappingEntity.getUserId());
        userMapping.setFirstName(userMappingEntity.getFirstName());
        userMapping.setLastName(userMappingEntity.getLastName());
        userMapping.setPassword(userMappingEntity.getPassword());
        userMapping.setUserCategory(userMappingEntity.getUserCategory());
        return userMapping;
    }

}
