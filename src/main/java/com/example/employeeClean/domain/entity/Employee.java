package com.example.employeeClean.domain.entity;
public class Employee {
    private Long id;
    private String name;
    private String email;
    private String department;
    private Double salary;

    private Employee(Long id, String name, String email, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public static Employee createNew(String name, String email, String department, Double salary){
        return new Employee(null,name,email,department,salary);
    }

    public void updateDetails(Employee empDetails){
        this.name = empDetails.getName();
        this.email = empDetails.getEmail();
        this.department = empDetails.getDepartment();
        this.salary = empDetails.getSalary();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
