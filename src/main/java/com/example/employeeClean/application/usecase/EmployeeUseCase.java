package com.example.employeeClean.application.usecase;

import com.example.employeeClean.application.port.in.EmployeeService;
import com.example.employeeClean.application.port.out.EmployeeRepositoryPort;
import com.example.employeeClean.domain.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeUseCase implements EmployeeService {

    private final EmployeeRepositoryPort employeeRepositoryPort;

    public EmployeeUseCase(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }


    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepositoryPort.save(employee);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepositoryPort.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepositoryPort.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee empTemp = employeeRepositoryPort.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));
        empTemp.setName(employeeDetails.getName());
        empTemp.setDepartment(employeeDetails.getDepartment());
        empTemp.setEmail(employeeDetails.getEmail());
        empTemp.setSalary(employeeDetails.getSalary());
        return employeeRepositoryPort.save(empTemp);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepositoryPort.delete(id);
    }
}
