package com.shopskill.anubis.rest.service;

import com.shopskill.anubis.domain.UserMapping;
import com.shopskill.anubis.repository.UserMappingEntity;
import com.shopskill.anubis.repository.UserMappingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMappingService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserMappingRepository userMappingRepository;

    @Autowired
    public UserMappingService(final UserMappingRepository userMappingRepository){
        this.userMappingRepository = userMappingRepository;
    }

    public UserMappingEntity createUserMapping(UserMapping request){
        UserMappingEntity mappingEntity = UserMappingEntity.map(request);
        log.info("Creating User Mapping For User : " + request.getUserName());
        return userMappingRepository.save(mappingEntity);
    }

}
