package com.shopskill.anubis.rest.controller;

import com.shopskill.anubis.domain.AuthenticationRequest;
import com.shopskill.anubis.rest.service.UserMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
