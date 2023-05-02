package com.example.Workstation.employee;

import com.example.Workstation.task.Task;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmplCont {
    @Autowired
    private EmpServ empServ;

    @GetMapping("/all")
    public List<Employee> getAllEmployeesWithSalaries() {
        return empServ.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        Optional<Employee> employee = empServ.getbyid(id);
        if(employee.isPresent()){
            return ResponseEntity.ok().body(employee.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/tasks/{name}")
    public List<Task> getTasksByName(@PathVariable("name") String name){
        return empServ.gettasksbyname(name);
    }

    @PostMapping("/addemp")
    public void addEmployee(@RequestBody Employee employee){
        empServ.addemp(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id") long id) {
        empServ.deletebyid(id);
    }

    @GetMapping("/department/{name}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("name") String department) {
        return empServ.getbydepartment(department);
    }

    @DeleteMapping("/name/{name}")
    public void deleteEmployeeByName(@PathVariable("name") String name) {
        empServ.delempbyname(name);
    }


}
