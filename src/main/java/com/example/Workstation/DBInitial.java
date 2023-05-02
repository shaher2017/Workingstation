package com.example.Workstation;

import com.example.Workstation.department.DepartServ;
import com.example.Workstation.department.Department;
import com.example.Workstation.department.DepartmentRepo;
import com.example.Workstation.employee.Employee;
import com.example.Workstation.employee.EmployeeRepo;
import com.example.Workstation.employee.Role;
import com.example.Workstation.task.Task;
import com.example.Workstation.task.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class DBInitial implements CommandLineRunner {
    private final EmployeeRepo empRepo;
    private final DepartmentRepo departRepo;
    private final TaskRepo taskRepo;


    @Override
    public void run(String... args) throws Exception {

        Task t1 = Task.builder().name("Get Cash In an Cashout").build(); taskRepo.save(t1);

        Department d1 = Department.builder().name("Technical office").build(); departRepo.save(d1);

        Employee e1 = Employee.builder().fname("Shaher").age(26).department(d1).role(Role.ROLE_MANAGER).salary(26000).tasks(new ArrayList<>()).build();
        e1.getTasks().add(t1); empRepo.save(e1);

    }
}
