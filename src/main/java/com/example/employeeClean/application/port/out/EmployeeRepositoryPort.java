package com.example.employeeClean.application.port.out;

import com.example.employeeClean.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryPort {
    Employee save(Employee employee);
    Optional<Employee> findById(long id);
    List<Employee> findAll();
    void delete(long id);
}
