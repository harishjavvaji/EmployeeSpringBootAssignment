package com.mypackage.demo.services;

import com.mypackage.demo.models.Employee;
import com.mypackage.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        employeeRepository.findAll().forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                list.add(employee);
            }
        });
        return list;
    }

    public Employee setEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee employee) {

        return employeeRepository.findById(employee.getId())
                .map(employee1 -> {
                    employee1.setSalary(employee.getSalary());
                    employee1.setEmpName(employee.getEmpName());
                    employee1.setDepartment(employee.getDepartment());
                    return employeeRepository.save(employee1);
                }).orElseGet(() ->{
                    return employeeRepository.save(employee);
                });
    }

    public void deleteEmployee(@RequestBody Employee employee) {

        employeeRepository.deleteById(employee.getId());

    }

//    public List<Employee> getEmployees(String department) {
//
//        return employeeRepository.fin
//    }

}
