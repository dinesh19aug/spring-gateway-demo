package com.javahabit.departmentservice.service;

import com.javahabit.departmentservice.domain.Department;
import com.javahabit.departmentservice.error.DataNotFoundException;


public interface IService {
    Department getDepartmentDetailsById(int departmentId) throws DataNotFoundException;

}
