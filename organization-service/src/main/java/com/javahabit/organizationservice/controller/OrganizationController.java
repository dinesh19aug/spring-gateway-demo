package com.javahabit.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org-service")
public class OrganizationController {
    @GetMapping(value = "/getOrganizationDetails", produces = "application/json")
    public ResponseEntity<String> getOrganizationDetails(){
        String returnObject ="{\"organizationId\":\"1\",\"name\":\"Organization\"}";

        return new ResponseEntity<>(returnObject, HttpStatus.OK);
    }
}
