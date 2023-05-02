package com.example.Workstation;

import com.example.Workstation.department.Department;
import com.example.Workstation.department.DepartmentRepo;
import com.example.Workstation.employee.Employee;
import com.example.Workstation.employee.EmployeeRepo;
import com.example.Workstation.task.Task;

import com.example.Workstation.task.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DBInitial implements CommandLineRunner {
    private EmployeeRepo empRepo;
    private DepartmentRepo departRepo;
    private TaskRepo taskRepo;

    @Autowired
    public DBInitial(EmployeeRepo empRepo, DepartmentRepo departRepo, TaskRepo taskRepo) {
        this.empRepo = empRepo;
        this.departRepo = departRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Task t1 = new Task(); t1.setName("Get Cash In an Cashout"); taskRepo.save(t1);
        Task t2 = new Task(); t2.setName("Secure the site"); taskRepo.save(t2);
        Task t3 = new Task(); t3.setName("secure the HQ"); taskRepo.save(t3);
        Task t4 = new Task(); t4.setName("Hiring people"); taskRepo.save(t4);
        Task t5 = new Task(); t5.setName("Complete Site 2"); taskRepo.save(t5);
       
        Department d1 = new Department();d1.setName("Technical office");departRepo.save(d1);
        Department d2 = new Department();d2.setName("HR");departRepo.save(d2);
        Department d3 = new Department();d3.setName("Excutive");departRepo.save(d3);
        Department d4 = new Department();d4.setName("Security");departRepo.save(d4);


        Employee e1 = new Employee();e1.setFname("Shaher"); e1.setAge(26);e1.setSalary(18000);e1.setDepartment(d1);e1.getTasks().add(t4);empRepo.save(e1);
        Employee e2 = new Employee();e2.setFname("Ahmed"); e2.setAge(30);e2.setSalary(22300);e2.setDepartment(d2);e2.getTasks().add(t1);empRepo.save(e2);
        Employee e3 = new Employee();e3.setFname("Mohammed"); e3.setAge(36);e3.setSalary(28000);e3.setDepartment(d4);e3.getTasks().add(t2);empRepo.save(e3);
        Employee e4 = new Employee();e4.setFname("Karem"); e4.setAge(39);e4.setSalary(12000);e4.setDepartment(d4);e4.getTasks().add(t3);empRepo.save(e4);
        Employee e5 = new Employee();e5.setFname("Saad"); e5.setAge(28);e5.setSalary(68000);e5.setDepartment(d3);e5.getTasks().add(t5);empRepo.save(e5);

    }
}
