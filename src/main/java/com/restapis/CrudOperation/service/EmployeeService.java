package com.restapis.CrudOperation.service;

import com.restapis.CrudOperation.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public String saveEmployee(Employee employee);

    public String updateEmployee(Employee employee);
}
