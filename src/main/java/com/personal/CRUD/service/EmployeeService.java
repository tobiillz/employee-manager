package com.personal.CRUD.service;

import com.personal.CRUD.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee>  getAllEmployees();
    Employee getEmployeeById(Long id);


}
