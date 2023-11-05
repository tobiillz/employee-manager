package com.personal.CRUD.controller;

import com.personal.CRUD.model.Employee;
import com.personal.CRUD.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //BUILD CREATE EMPLOYEE REST API

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //BUILD GET ALL EMPLOYEES REST API
    @GetMapping("")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    //BUILD GET EMPLOYEE BY ID REST API
}

