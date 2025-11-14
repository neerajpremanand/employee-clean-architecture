package com.example.employeeClean.infrasturcture.adaptor.out.persistence.repository;

import com.example.employeeClean.infrasturcture.adaptor.out.persistence.entity.EmployeeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeJpaEntity, Long> {
}
