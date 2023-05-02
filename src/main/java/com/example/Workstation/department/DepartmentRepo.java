package com.example.Workstation.department;

import com.example.Workstation.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Optional<Department> findByname(String name);
    @Query("SELECT SUM(e.salary), d.name FROM Employee e JOIN e.department d GROUP BY d.name")
    List<Object[]> findsumdepartments();





}
