package com.example.Workstation.task;

import com.example.Workstation.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskCont {
    @Autowired
    private TaskServ taskService;

    @GetMapping("/all")
    public List<Task>getalltasks(){return taskService.getAllTasks();}

    @PostMapping("/add")
    public void addtask(@RequestBody Task t){taskService.addtask(t);}
    @DeleteMapping("/deletetask/{id}")
    public void deletetask(@PathVariable("id") long id){taskService.deletetask(id);}



}
