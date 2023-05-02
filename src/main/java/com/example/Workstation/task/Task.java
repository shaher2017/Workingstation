package com.example.Workstation.task;

import com.example.Workstation.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    private LocalDate deadline;

    @ManyToMany
    @JoinTable(name = "emp_task", joinColumns = {@JoinColumn(name = "task_id")} , inverseJoinColumns = {@JoinColumn(name = "emp_id")})
    private List <Employee> employees;

}
