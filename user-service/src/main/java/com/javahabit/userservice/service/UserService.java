package com.javahabit.userservice.service;

import com.javahabit.userservice.domain.User;
import com.javahabit.userservice.error.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements IService{
    List<User> userList;
    UserService(){
        addUser();
    }


    private void addUser() {
        userList = new ArrayList<>();
        userList.add( new User(1, "Dinesh", "Arora", new Date(1954, Calendar.DECEMBER,24),101));
        userList.add( new User(2, "David", "Jones", new Date(1962,Calendar.SEPTEMBER,14),102));
        userList.add( new User(3, "Keith", "Williams", new Date(1983,Calendar.MARCH,19),103));
        userList.add( new User(4, "David", "Mallock", new Date(1994,Calendar.JULY,18),104));
    }

    @Override
    public User fetchUserByDepartment(int departmentId) throws DataNotFoundException {
        return userList.stream()
                .filter(u ->  u.department()==departmentId)
                .findFirst()
                .orElseThrow(()->new DataNotFoundException("User not found in this department"));
    }

    @Override
    public User fetchUserById(int userId) throws DataNotFoundException {
        return userList.stream()
                .filter(u ->  u.id()==userId)
                .findFirst()
                .orElseThrow(()->new DataNotFoundException("User not found"));
    }
}
