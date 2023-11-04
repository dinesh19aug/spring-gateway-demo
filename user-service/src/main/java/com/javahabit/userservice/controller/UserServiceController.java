package com.javahabit.userservice.controller;

import com.javahabit.userservice.domain.User;
import com.javahabit.userservice.error.DataNotFooundException;
import com.javahabit.userservice.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserServiceController {
    IService userService;
    UserServiceController(IService service){
        this.userService = service;
    }
    @GetMapping(value = "/getUserDetailsById",produces = "application/json")
    public ResponseEntity<String> getUserDetailsById(@RequestParam String id){
        String returnObject ="{\"id\":\"101\",\"firstName\":\"Dinesh\",\"lastName\":\"Arora\",\"dob\":\"01/01/2000\",\"dept\":\"1\" }";

        return new ResponseEntity<>(returnObject, HttpStatus.OK);
    }

    @GetMapping(value = "/getUsersByDeptId", produces = "application/json")
    public ResponseEntity<User> getUsersByDeptId(@RequestParam String deptId) throws DataNotFooundException {

        return new ResponseEntity<>(userService.fetchUserByDepartment(Integer.parseInt(deptId)), HttpStatus.OK);
    }
}
