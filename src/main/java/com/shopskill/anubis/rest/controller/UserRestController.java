package com.shopskill.anubis.rest.controller;

import com.shopskill.anubis.domain.UserMapping;
import com.shopskill.anubis.repository.UserMappingEntity;
import com.shopskill.anubis.rest.service.UserMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserMappingService userMappingService;

    @Autowired
    public UserRestController(final UserMappingService userMappingService) {
        this.userMappingService = userMappingService;
    }

    @GetMapping
    public ResponseEntity getUserMapping(@RequestParam("userId") final String userId) {
        UserMapping response = userMappingService.getUserMapping(userId);
        if (response == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User Details Not Found For User Id : " + userId);
        }
        return ResponseEntity.accepted().body(response);
    }

    @PostMapping("/create")
    public ResponseEntity createUserMapping(@Valid @RequestBody final UserMapping request) {
        try {
            UserMappingEntity response = userMappingService.createUserMapping(request);
            log.info("User Mapping Creation SUCCESSFUL For User : " + request.getFirstName()
                    + " With Id : " + response.getUserId());
            return ResponseEntity.accepted().body(response);
        } catch (Exception e) {
            log.error("User Mapping Creation FAILED For User : " + request.getFirstName() + " " + request.getLastName());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
