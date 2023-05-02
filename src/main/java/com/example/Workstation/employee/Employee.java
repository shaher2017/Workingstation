package com.example.Workstation.employee;
import com.example.Workstation.department.Department;
import com.example.Workstation.task.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String fname;

    @NotNull
    @Min(18)
    private Integer age;

    @NotNull
    @Positive
    private int salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "emp_task", joinColumns = {@JoinColumn(name = "emp_id")} , inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private List<Task> tasks;

    @Enumerated(EnumType.STRING)
    private Role role;

}