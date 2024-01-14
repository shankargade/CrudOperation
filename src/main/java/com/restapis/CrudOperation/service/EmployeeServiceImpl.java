package com.restapis.CrudOperation.service;

import com.restapis.CrudOperation.Constants.Message;
import com.restapis.CrudOperation.controller.FirstController;
import com.restapis.CrudOperation.entities.Employee;
import com.restapis.CrudOperation.entities.PhoneNumber;
import com.restapis.CrudOperation.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public String saveEmployee(Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setEmpId(employee.getEmpId());
        newEmployee.setName(employee.getName());
        newEmployee.setCity(employee.getCity());
        newEmployee.setAddress(employee.getAddress());
        newEmployee.setMobNo(employee.getMobNo());

        Set<PhoneNumber> newPhoneNumberSet = new HashSet<>();

        for (PhoneNumber phoneNumber : employee.getPhoneNumber()) {
            phoneNumber.setEmployee(newEmployee);
            phoneNumber.setMobileNumber(phoneNumber.getMobileNumber());
            newPhoneNumberSet.add(phoneNumber);
        }
        newEmployee.setPhoneNumber(newPhoneNumberSet);

        return employeeRepo.save(newEmployee).toString();
        // Address
        // Email Address
        // Search by mobile
        //
    }

    @Override
    public String updateEmployee(Employee employee) {

        // Check whether this employee is present
        Optional<Employee> employeeFromDB = employeeRepo.findById(employee.getEmpId());
        Employee oldEmployee = employeeFromDB.get();
        if (employeeFromDB.isPresent()) {
            //Employee updateEmplyee = new Employee();
            oldEmployee.setName(employee.getName());
            oldEmployee.setCity(employee.getCity());
            oldEmployee.setAddress(employee.getAddress());
            oldEmployee.setMobNo(employee.getMobNo());

            Set<PhoneNumber> newphoneNumberSet = employee.getPhoneNumber();
            Set<PhoneNumber> oldPhoneNumberSet = oldEmployee.getPhoneNumber();

            for (PhoneNumber phoneNumber : newphoneNumberSet) {

                for (PhoneNumber phoneNumber1 : oldPhoneNumberSet)
                {

                    if (phoneNumber.getPhoneNumberId() == phoneNumber1.getPhoneNumberId()) {
                        phoneNumber1.setEmployee(oldEmployee);
                        phoneNumber1.setMobileNumber(phoneNumber.getMobileNumber());
                    }
                }

            }
            oldEmployee.setPhoneNumber(oldPhoneNumberSet);

            return String.valueOf(employeeRepo.save(oldEmployee));

            // update the record
        } else {
            return Message.NOT_FOUND;
        }


    }
}
