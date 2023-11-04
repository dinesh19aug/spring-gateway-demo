package com.javahabit.userservice.service;

import com.javahabit.userservice.domain.User;
import com.javahabit.userservice.error.DataNotFoundException;

public interface IService {
    User fetchUserByDepartment(int departmentId) throws DataNotFoundException;
    User fetchUserById(int userId) throws DataNotFoundException;
}
