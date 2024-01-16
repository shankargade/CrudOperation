package com.restapis.CrudOperation.controller;

import com.restapis.CrudOperation.Constants.Message;
import com.restapis.CrudOperation.SchedulerJobs.ApplicationCacheImplementer;
import com.restapis.CrudOperation.entities.Employee;
import com.restapis.CrudOperation.entities.PhoneNumber;
import com.restapis.CrudOperation.repo.EmployeeRepo;
import com.restapis.CrudOperation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class FirstController {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/sayhello")
    public String HelloWorld() {
        System.out.println("First Try of return Api");
        return "First Try of return Api";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/updateEmployee")
    public String updateEmployeee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }


    @DeleteMapping("/deleteEmployee/{empID}")
    public String deleteEmployee(@PathVariable int empID) {

        Optional<Employee> employee1 = employeeRepo.findById(empID);
        if (employee1.isPresent()) {
            employeeRepo.deleteById(empID);

            return "employee deleted successfully";
        } else {

            return Message.NOT_FOUND;
        }


    }


    @DeleteMapping("/deleteEmployee/{empID}")
    public String deleteEmployeOne(@PathVariable int empID) {

        Optional<Employee> employee1 = employeeRepo.findById(empID);
        if (employee1.isPresent()) {
            employeeRepo.deleteById(empID);

            return "employee deleted successfully";
        } else {

            return Message.NOT_FOUND;
        }


    }


    // Search operation Read operation
    // We can find the existing employee with different parameters like empid, empname etc.
    // URL -->http://localhost:8080/finbyID/2
    @GetMapping("/findbyID/{empId}")
    public String findEmployeeByID(@PathVariable int empId)
    {
// This is the commint i have added for fun
        Employee s1 = ApplicationCacheImplementer.appCache.get(empId);

        if (s1 != null)
        {
            return s1.toString();
        }
        else
        {
            Optional<Employee> employee = employeeRepo.findById(empId);
            if (employee.isPresent())
            {
              return  employee.get().toString();
            }
            else
            {
                return Message.NOT_FOUND;
            }
        }

    }
    // Write the api to find the employee record from the DB by employee name.

    @GetMapping("/findByName/{empName}")
    public List<Optional<Employee>> findEmpByName(@PathVariable String empName) {
        List<Optional<Employee>> employeeList = employeeRepo.findByName(empName);
        return employeeList;
    }

    @GetMapping("/findByCity/{empCity}")
    public List<Optional<Employee>> findBycity(@PathVariable String empCity) {
        List<Optional<Employee>> employeeList1 = employeeRepo.findByCity(empCity);
        return employeeList1;
    }

    @GetMapping("findByMobileNo/{mob_no}")
    public List<Optional<Employee>> findByMob(@PathVariable String mob_no) {
        List<Optional<Employee>> emplist = employeeRepo.findByMobNo(mob_no);
        return emplist;
    }

    @GetMapping("/orderBySalary")
    public List<Optional<Employee>> orderBySalary() {

        List<Optional<Employee>> emplist1 = employeeRepo.orderBysalary();
        return emplist1;

    }


    @GetMapping("/findbyIDRequestParam")
    public String findEmployeeByIDRequestParam(@RequestParam int empId) {

        Optional<Employee> employee = employeeRepo.findById(empId);

        if (employee.isPresent()) {
            return employee.toString();
        } else {
            return Message.NOT_FOUND;
        }

    }
}
