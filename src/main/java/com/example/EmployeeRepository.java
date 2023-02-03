package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements EmployeeRepositoryinterface {

    @Override
    public List<Employee> findAll() {
        List <Employee> employees = new ArrayList<>();
        employees.add(new Employee("Emma", 45000));
        employees.add(new Employee("Aaron", 44000));
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
