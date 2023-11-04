package com.javahabit.userservice.controller;

import com.javahabit.userservice.domain.User;
import com.javahabit.userservice.error.DataNotFoundException;
import com.javahabit.userservice.service.IService;
import com.javahabit.userservice.vo.Error;
import com.javahabit.userservice.vo.UserResponseVO;
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
    public ResponseEntity<UserResponseVO> getUserDetailsById(@RequestParam String id){
        UserResponseVO userResponseVO;
        try {
            User user = userService.fetchUserById(Integer.parseInt(id));
            userResponseVO=new UserResponseVO(user,null);
        }catch (DataNotFoundException dne){
            Error error= new Error(dne.getMessage());
            userResponseVO=new UserResponseVO(null,error);
        }
        return new ResponseEntity<>(userResponseVO, HttpStatus.OK);
    }

    @GetMapping(value = "/getUsersByDeptId", produces = "application/json")
    public ResponseEntity<UserResponseVO> getUsersByDeptId(@RequestParam String deptId) throws DataNotFoundException {
        UserResponseVO userResponseVO;
        try {
            User user = userService.fetchUserByDepartment(Integer.parseInt(deptId));
            userResponseVO=new UserResponseVO(user,null);
        }catch (DataNotFoundException dne){
            Error error= new Error(dne.getMessage());
            userResponseVO=new UserResponseVO(null,error);
        }
        return new ResponseEntity<>(userResponseVO, HttpStatus.OK);
    }
}
