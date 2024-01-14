package com.restapis.CrudOperation.SchedulerJobs;

import com.restapis.CrudOperation.entities.Employee;
import com.restapis.CrudOperation.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class ApplicationCacheImplementer {

    public static HashMap<Integer, Employee> appCache = new HashMap<>();

    @Autowired
    EmployeeRepo employeeRepo;

    // Timer
    // Complete Project -->API -->Hands-on complete -->Group war
    // Repo -->Incomplete -->Features -->Develop -->Industry -->Code -->Review -->Merge -->Repo
    // Spring boot -->
    // Theory -->Session -->IOC/DI/Spring Boot features// annotation// create //starters
    // Weekend --morning//evening

    @Scheduled(cron = "0 */3 * ? * *")  // Timer
    public void loadApplicationCache()
    {
        System.out.println("Application Cache Loading Started");
        List<Employee> employeeList = employeeRepo.findAll();

        for (Employee employee : employeeList)
        {
            appCache.put(employee.getEmpId(), employee);
        }
        System.out.println("Application Cache Loading Ended");
    }
}
