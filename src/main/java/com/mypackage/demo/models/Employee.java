package com.mypackage.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeedata")
public class Employee {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "salary")
    int salary;
    @Column(name = "empname")
    String empName;
    @Column(name = "department")
    String department;

    public Employee() {
    }

    public Employee(int id, int salary, String empName, String department) {
        this.id = id;
        this.salary = salary;
        this.empName = empName;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
