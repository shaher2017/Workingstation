package com.example.Workstation.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServ {

    @Autowired
    TaskRepo taskRepo;
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
    public void addtask(Task t){taskRepo.save(t);}
    public void deletetask(long id){taskRepo.delete(taskRepo.findById(id).get());}
}
