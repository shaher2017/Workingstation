package com.example.Workstation.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServ {

    @Autowired
    TaskRepo taskRepo;

    public List<Task> getAllTasksWithEmployees() {
        return taskRepo.findAll();
    }

    // Method to get all tasks with the assigned departments
    public List<Task> getAllTasksWithDepartments() {
        return taskRepo.findAll();
    }

    // Method to get all tasks
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
}
