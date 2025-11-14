package com.example.employeeClean.infrasturcture.adaptor.out.persistence;

import com.example.employeeClean.application.port.out.EmployeeRepositoryPort;
import com.example.employeeClean.domain.entity.Employee;
import com.example.employeeClean.infrasturcture.adaptor.out.persistence.entity.EmployeeJpaEntity;
import com.example.employeeClean.infrasturcture.adaptor.out.persistence.repository.EmployeeJpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryAdaptor implements EmployeeRepositoryPort {

    private final EmployeeJpaRepository jpaRepository;

    public EmployeeRepositoryAdaptor(EmployeeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeJpaEntity empJpa = convertToEmpJpa(employee);
        return convertToEmp(jpaRepository.save(empJpa));
    }

    @Override
    public Optional<Employee> findById(long id) {
        Optional<EmployeeJpaEntity> jpaEntity = jpaRepository.findById(id);
        return jpaEntity.map(this::convertToEmp);
    }

    @Override
    public List<Employee> findAll() {
        List<EmployeeJpaEntity> jpaList = jpaRepository.findAll();
        List<Employee> empList = new ArrayList<>();
        for(EmployeeJpaEntity emp:jpaList){
            Employee tempEmp= convertToEmp(emp);
            empList.add(tempEmp);
        }
        return empList;
    }

    @Override
    public void delete(long id) {
        jpaRepository.deleteById(id);
    }

    private Employee convertToEmp(EmployeeJpaEntity jpaEmp){
        Employee employee=new Employee();
        employee .setId(jpaEmp.getId());
        employee.setName(jpaEmp.getName());
        employee.setEmail(jpaEmp.getEmail());
        employee.setDepartment(jpaEmp.getDepartment());
        employee.setSalary(jpaEmp.getSalary());
        return employee;
    }

    private EmployeeJpaEntity convertToEmpJpa(Employee emp){
        EmployeeJpaEntity empJpa=new EmployeeJpaEntity();
        empJpa.setId(emp.getId());
        empJpa.setName(emp.getName());
        empJpa.setEmail(emp.getEmail());
        empJpa.setDepartment(emp.getDepartment());
        empJpa.setSalary(emp.getSalary());
        return empJpa;
    }
}
