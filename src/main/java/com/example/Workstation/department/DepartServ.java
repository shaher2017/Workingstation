package com.example.Workstation.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartServ {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
    public List<Object[]> getsumsalaryfordepartment(){return departmentRepo.findsumdepartments();}

    public Department getbyname(String s){
        if(departmentRepo.findByname(s).isPresent())
        return departmentRepo.findByname(s).get();
        else return null;
    }
}
