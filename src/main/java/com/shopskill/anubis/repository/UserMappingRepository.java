package com.shopskill.anubis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMappingRepository extends MongoRepository<UserMappingEntity, String> {
}
