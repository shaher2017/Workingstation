package com.example.Workstation.department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Object []> getsumsalaryfordepartment() {
        return departServ.getsumsalaryfordepartment();
    }

    @GetMapping("/byname")
    public Department getbyname(@RequestParam("name") String s){return departServ.getbyname(s);}

}
