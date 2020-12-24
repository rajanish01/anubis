package com.shopskill.anubis.repository;

import com.shopskill.anubis.enums.UserCategory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "user_id_sequence")
public class UserIdSequenceEntity {

    @Id
    private String id;

    private UserCategory userCategory;

    private Integer startIndex;

    private Integer currentIndex;

    private String prefix;

    public UserIdSequenceEntity(UserCategory userCategory, Integer startIndex,
                                Integer currentIndex, String prefix) {
        this.userCategory = userCategory;
        this.startIndex = startIndex;
        this.currentIndex = currentIndex;
        this.prefix = prefix;
    }
}
