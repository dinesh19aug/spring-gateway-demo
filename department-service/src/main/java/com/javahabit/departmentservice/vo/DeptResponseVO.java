package com.javahabit.departmentservice.vo;


import com.javahabit.departmentservice.domain.Department;

public record DeptResponseVO(Department department, Error error) {

}
