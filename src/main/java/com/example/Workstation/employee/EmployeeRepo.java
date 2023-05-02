package com.example.Workstation.employee;

import com.example.Workstation.employee.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByFname(String name);
    @Query("SELECT e.fname, e.age, e.salary, d.name, t.name FROM Employee e JOIN e.department d LEFT JOIN e.tasks t")
    List<Object[]> getnams();
}