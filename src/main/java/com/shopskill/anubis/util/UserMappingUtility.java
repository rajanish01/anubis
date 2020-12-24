package com.shopskill.anubis.util;

import com.shopskill.anubis.domain.UserMapping;
import com.shopskill.anubis.enums.UserCategory;
import com.shopskill.anubis.repository.UserIdSequenceEntity;
import com.shopskill.anubis.repository.UserIdSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMappingUtility {

    private final UserIdSequenceRepository userIdSequenceRepository;

    @Autowired
    public UserMappingUtility(final UserIdSequenceRepository userIdSequenceRepository) {
        this.userIdSequenceRepository = userIdSequenceRepository;
    }

    public String generateUniqueUserId(UserMapping userMapping) {
        return getNextIndex(userMapping.getUserCategory());
    }

    private String getNextIndex(UserCategory userCategory) {
        Optional<UserIdSequenceEntity> sequenceEntity = userIdSequenceRepository.findByUserCategory(userCategory);
        if (sequenceEntity.isEmpty()) {
            createNewUserIdSequence(userCategory);
            sequenceEntity = userIdSequenceRepository.findByUserCategory(userCategory);
        }
        sequenceEntity.get().setCurrentIndex(sequenceEntity.get().getCurrentIndex() + 1);
        UserIdSequenceEntity persistedSequence = userIdSequenceRepository.save(sequenceEntity.get());
        int newIndex = persistedSequence.getStartIndex() + persistedSequence.getCurrentIndex();
        return persistedSequence.getPrefix() + newIndex;
    }

    private void createNewUserIdSequence(UserCategory userCategory) {
        switch (userCategory) {
            case CUSTOMER:
                userIdSequenceRepository.save(new UserIdSequenceEntity(
                        userCategory, Constants.START_INDEX, 0, Constants.CUSTOMER_PREFIX));
                break;
            case ADMIN:
                userIdSequenceRepository.save(new UserIdSequenceEntity(
                        userCategory, Constants.START_INDEX, 0, Constants.ADMIN_PREFIX));
                break;
            case SELLER:
                userIdSequenceRepository.save(new UserIdSequenceEntity(
                        userCategory, Constants.START_INDEX, 0, Constants.SELLER_PREFIX));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + userCategory);
        }
    }

}
