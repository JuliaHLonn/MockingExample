package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepositoryinterface {

    @Override
    public List<Employee> findAll() {
        List <Employee> employees = new ArrayList<>();
        employees.add(new Employee("6", 45000,true));
        employees.add(new Employee("7", 44000,true));
        employees.add(new Employee("8", 49000,true));

        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
