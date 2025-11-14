package com.example.employeeClean.infrasturcture.adaptor.in.web;

import com.example.employeeClean.application.port.in.EmployeeService;
import com.example.employeeClean.domain.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee emp){
        Employee newEmployee = employeeService.createEmployee(emp);
        return ResponseEntity.ok(newEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployee();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee updateEmp){
        Employee updatedEmp = employeeService.updateEmployee(id,updateEmp);
        return ResponseEntity.ok(updatedEmp);
    }


}
