package com.javahabit.departmentservice.controller;

import com.javahabit.departmentservice.domain.Department;
import com.javahabit.departmentservice.error.DataNotFoundException;
import com.javahabit.departmentservice.service.IService;
import com.javahabit.departmentservice.service.UserClientService;
import com.javahabit.departmentservice.vo.DeptResponseVO;

import com.javahabit.departmentservice.vo.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    IService departmentService;
    UserClientService userClientService;
    DepartmentController(UserClientService userClientService, IService departmentService) {
        this.userClientService = userClientService;
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/getDepartmentDetailsById", produces = "application/json")
    public ResponseEntity<DeptResponseVO> getDepartmentDetailsById(@RequestParam String id) {
        DeptResponseVO deptResponseVO;
        try {
            Department department = departmentService.getDepartmentDetailsById(Integer.parseInt(id));
            deptResponseVO=new DeptResponseVO(department,null);
        }catch (DataNotFoundException dne){
            Error error= new Error(dne.getMessage());
            deptResponseVO=new DeptResponseVO(null,error);
        }
        return new ResponseEntity<>(deptResponseVO, HttpStatus.OK);
    }

    @GetMapping(value = "/getUsersByDeptId", produces = "application/json")
    public ResponseEntity<String> getUsersByDeptId(@RequestParam String deptId) {
        return userClientService.getUsersByDeptId(deptId);
    }
}
