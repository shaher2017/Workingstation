package com.example.Workstation.employee;

import com.example.Workstation.department.Department;
import com.example.Workstation.department.DepartmentRepo;
import com.example.Workstation.task.Task;
import com.example.Workstation.task.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmpServ {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    TaskRepo taskRepo;
    public List<Employee> getAllEmployees() {
        System.out.println(employeeRepo.findAll());
        return employeeRepo.findAll();}
    public Optional<Employee> getbyid(long id){
        return employeeRepo.findById(id);}
   public Set<Task> gettasksbyname(String name){
        return employeeRepo.findByFname(name).getTasks();}
    public void addemp(Employee employee){
        if(departmentRepo.findByname(employee.getDepartment().getName()).isPresent())
        {Department d = departmentRepo.findByname(employee.getDepartment().getName()).get();departmentRepo.save(d); employee.setDepartment(d);}
        else {Department d = employee.getDepartment();departmentRepo.save(d);}
        Set<Task> tasks = employee.getTasks();
        tasks.forEach(task -> taskRepo.save(task));
        employeeRepo.save(employee);}
    public void delempbyname(String name) {employeeRepo.delete(employeeRepo.findByFname(name));}
    public void deletebyid(long id) {employeeRepo.deleteById(id);}
    public Set<Employee> getbydepartment(String department){ return departmentRepo.findByname(department).get().getEmployees();}

   public List<Object[]> getnames(){return employeeRepo.getnams();}

}
