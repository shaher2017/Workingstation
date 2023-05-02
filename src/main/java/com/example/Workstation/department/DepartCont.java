package com.example.Workstation.department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/department")
public class DepartCont {

    @Autowired
    public DepartServ departServ;

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departServ.getAllDepartments();
    }

    @GetMapping("/departments/salary")
    public List<Objects []> getsumsalaryfordepartment() {
        return departServ.getsumsalaryfordepartment();
    }

    @GetMapping("/managers")
    public List<Objects []> getallmanagers(){return departServ.getdepartmentwithmanagers();}
}
