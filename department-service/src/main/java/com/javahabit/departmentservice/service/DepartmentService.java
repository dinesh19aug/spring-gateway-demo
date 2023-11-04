package com.javahabit.departmentservice.service;

import com.javahabit.departmentservice.domain.Department;
import com.javahabit.departmentservice.error.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements IService {
    List<Department> deptList;
    DepartmentService(){
        addDepartmenrt();
    }


    private void addDepartmenrt() {
        deptList = new ArrayList<>();
        deptList.add( new Department(101, "Accounts"));
        deptList.add( new Department(102, "Marketing"));
        deptList.add( new Department(103, "Sales"));
        deptList.add( new Department(104, "IT"));
    }


    @Override
    public Department getDepartmentDetailsById(int departmentId) throws DataNotFoundException {
        return deptList.stream()
                .filter(u ->  u.deptId()==departmentId)
                .findFirst()
                .orElseThrow(()->new DataNotFoundException("Department not found"));
    }
}
