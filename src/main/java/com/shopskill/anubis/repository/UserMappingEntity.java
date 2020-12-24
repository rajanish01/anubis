package com.shopskill.anubis.repository;

import com.shopskill.anubis.domain.UserMapping;
import com.shopskill.anubis.enums.UserCategory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "user_mapping")
public class UserMappingEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;
    private String password;

    private UserCategory userCategory;

    public static UserMappingEntity map(UserMapping userMapping) {
        UserMappingEntity userMappingEntity = new UserMappingEntity();
        userMappingEntity.setUserName(userMapping.getUserName());
        userMappingEntity.setPassword(userMapping.getPassword());
        userMappingEntity.setUserCategory(userMapping.getUserCategory());
        return userMappingEntity;
    }

}
