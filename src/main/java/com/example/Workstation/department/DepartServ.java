package com.example.Workstation.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartServ {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
    public List<Objects[]> getsumsalaryfordepartment(){return departmentRepo.findsumdepartments();}

    public List<Objects []> getdepartmentwithmanagers(){
       return departmentRepo.getdepartswithmanagers();
    }

}
