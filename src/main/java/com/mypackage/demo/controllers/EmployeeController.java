package com.mypackage.demo.controllers;

import com.mypackage.demo.models.Employee;
import com.mypackage.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee setEmployee(@RequestBody Employee employee) {

        return employeeService.setEmployee(employee);

    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") int id) {

        return employeeService.getEmployee(id);

    }

    @PutMapping(value = "/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping(value = "/employees")
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }

//    @RequestMapping(value = "/employee")
//    public List<Employee> getEmployees(@RequestParam String department) {
//        return employeeService.getEmployees(department);
//    }
}
