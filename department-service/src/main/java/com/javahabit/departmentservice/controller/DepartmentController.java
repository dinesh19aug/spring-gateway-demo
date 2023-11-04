package com.javahabit.departmentservice.controller;

import com.javahabit.departmentservice.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    UserClientService userClientService;
@GetMapping(value = "/getDepartmentDetailsById", produces = "application/json")
public ResponseEntity<String> getDepartmentDetailsById(@RequestParam String id){
    String returnObject ="{\"deptId\":\"1\",\"name\":\"Security\"}";

    return new ResponseEntity<>(returnObject, HttpStatus.OK);
}

    @GetMapping(value = "/getUsersByDeptId",  produces = "application/json")
    public ResponseEntity<String> getUsersByDeptId(@RequestParam String deptId){
        return userClientService.getUsersByDeptId(deptId);
    }
}
