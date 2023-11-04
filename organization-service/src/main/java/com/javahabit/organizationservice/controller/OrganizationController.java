package com.javahabit.organizationservice.controller;

import com.javahabit.organizationservice.service.IService;
import com.javahabit.organizationservice.vo.OrgResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org-service")
public class OrganizationController {
    IService organizationService;
    OrganizationController(IService organizationService){
        this.organizationService = organizationService;
    }
    @GetMapping(value = "/getOrganizationDetails", produces = "application/json")
    public ResponseEntity<OrgResponseVO> getOrganizationDetails(){
        OrgResponseVO orgResponseVO = new OrgResponseVO(organizationService.getOrgDetail());

        return new ResponseEntity<>(orgResponseVO, HttpStatus.OK);
    }
}
