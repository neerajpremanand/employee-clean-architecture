package com.example.employeeClean.application.port.in;

import com.example.employeeClean.domain.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee findById(long id);
    List<Employee> findAllEmployee();
    Employee updateEmployee(Long id,Employee employeeDetails);
    void deleteEmployee(long id);
}
