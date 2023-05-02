package com.example.Workstation.employee;

import com.example.Workstation.department.DepartmentRepo;
import com.example.Workstation.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServ {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    public List<Employee> getAllEmployees() {
        System.out.println(employeeRepo.findAll());
        return employeeRepo.findAll();}
    public Optional<Employee> getbyid(long id){
        return employeeRepo.findById(id);}
    public List<Task> gettasksbyname(String name){
        return employeeRepo.findByFname(name).getTasks();}
    public void addemp(Employee employee){employeeRepo.save(employee);}
    public void delempbyname(String name) {employeeRepo.delete(employeeRepo.findByFname(name));}
    public void deletebyid(long id) {employeeRepo.deleteById(id);}
    public List<Employee> getbydepartment(String department){ return departmentRepo.findByName(department).getEmployees();}

}
