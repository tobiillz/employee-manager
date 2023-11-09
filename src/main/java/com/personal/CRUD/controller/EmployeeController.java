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
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //BUILD GET EMPLOYEE BY ID REST API(Returns specific employee by ID)
    //http://localhost:8080/api/employees/3
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    //BUILD UPDATE EMPLOYEE REST API
    //http://localhost:8080/api/employees/3
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,
                                                   @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);

    }
    //BUILD DELETE EMPLOYEE REST EMPLOYEE
    //http://localhost:8080/api/employees/3
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){

        //Delete employee from database
         employeeService.deleteEmployee(employeeId);
         return new ResponseEntity<String>("Employee has been successfully deleted!", HttpStatus.OK);
    }



}

