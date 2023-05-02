package com.example.Workstation.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@EnableJpaRepositories
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Department findByName(String name);
    @Query("SELECT SUM(e.salary), d.name FROM Employee e JOIN e.department d GROUP BY d.name")
    List<Objects[]> findsumdepartments();


    @Query("SELECT e.fname, d.name FROM Department d JOIN d.employees e WHERE e.role = 'ROLE_MANAGER'")
    List<Objects []> getdepartswithmanagers();



}
