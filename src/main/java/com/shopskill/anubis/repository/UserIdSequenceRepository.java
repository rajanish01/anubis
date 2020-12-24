package com.shopskill.anubis.repository;

import com.shopskill.anubis.enums.UserCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserIdSequenceRepository extends MongoRepository<UserIdSequenceEntity, Long> {

    Optional<UserIdSequenceEntity> findByUserCategory(UserCategory userCategory);

}
