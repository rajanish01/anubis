package com.shopskill.anubis.rest.controller;

import com.shopskill.anubis.domain.AuthenticationRequest;
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
@RequestMapping("/authenticate")
public class AuthenticationRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserMappingService userMappingService;

    @Autowired
    public AuthenticationRestController(final UserMappingService userMappingService) {
        this.userMappingService = userMappingService;
    }

    @GetMapping()
    public void userAuthenticator(@RequestBody final AuthenticationRequest request) {

    }

    @PostMapping()
    public ResponseEntity createUserMapping(@Valid @RequestBody final UserMapping request) {
        try {
            UserMappingEntity response = userMappingService.createUserMapping(request);
            log.info("User Mapping Creation SUCCESSFUL For User : " + request.getUserName());
            return ResponseEntity.accepted().body(response);
        } catch (Exception e) {
            log.info("User Mapping Creation FAILED For User : " + request.getUserName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
