package com.javahabit.userservice.service;

import com.javahabit.userservice.domain.User;
import com.javahabit.userservice.error.DataNotFooundException;

public interface IService {
    User fetchUserByDepartment(int departmentId) throws DataNotFooundException;
}
