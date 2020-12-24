package com.shopskill.anubis.rest.service;

import com.shopskill.anubis.domain.UserMapping;
import com.shopskill.anubis.repository.UserMappingEntity;
import com.shopskill.anubis.repository.UserMappingRepository;
import com.shopskill.anubis.util.UserMappingUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserMappingService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserMappingRepository userMappingRepository;
    private final UserMappingUtility userMappingUtility;

    @Autowired
    public UserMappingService(final UserMappingRepository userMappingRepository,
                              final UserMappingUtility userMappingUtility) {
        this.userMappingRepository = userMappingRepository;
        this.userMappingUtility = userMappingUtility;
    }

    public UserMapping getUserMapping(String userId) {
        Optional<UserMappingEntity> userDetails = userMappingRepository.findByUserId(userId);
        return userDetails.map(UserMapping::map).orElse(null);
    }

    public UserMappingEntity createUserMapping(UserMapping request) {
        UserMappingEntity mappingEntity = UserMappingEntity.map(request);
        mappingEntity.setUserId(userMappingUtility.generateUniqueUserId(request));
        log.info("Creating User Mapping For User : " + request.getFirstName() + " " + request.getLastName());
        return userMappingRepository.save(mappingEntity);
    }

    public UserMappingEntity updateUserMapping(UserMapping request) {
        Optional<UserMappingEntity> existingUser = userMappingRepository.findByUserId(request.getUserId());
        if(existingUser.isEmpty()){
            throw new NoSuchElementException("User With User Id Not Found : "+request.getUserId());
        }
        UserMappingEntity mappingEntity = UserMappingEntity.map(request);
        mappingEntity.setId(existingUser.get().getId());
        mappingEntity.setUserId(request.getUserId());
        log.info("Updating User Mapping For User : " + request.getUserId());
        return userMappingRepository.save(mappingEntity);
    }

}
