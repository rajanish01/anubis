package com.shopskill.anubis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMappingRepository extends MongoRepository<UserMappingEntity, String> {

    Optional<UserMappingEntity> findByUserId(String userId);

}
