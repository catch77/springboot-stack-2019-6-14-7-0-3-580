package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    public void deleteEmployeeByName(String name) {
        List<Employee> employee = employeeList.stream().filter(employee1 -> employee1.getName().equals(name)).collect(Collectors.toList());
        employeeList.removeAll(employee);
    }

    public Employee updateEmployeeByName(Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equals(employee.getName())) {
                employeeList.remove(employeeList.get(i));
                employeeList.add(employee);
                return employee;
            }
        }
        return null;
    }
}
