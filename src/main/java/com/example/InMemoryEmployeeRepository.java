package com.example;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeeRepository implements EmployeeRepositoryinterface{

    List<Employee> employeeList = new ArrayList<>();

    public InMemoryEmployeeRepository(){};
    public InMemoryEmployeeRepository(List<Employee> list){
        this.employeeList = list;
    };
    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public Employee save(Employee e) {
        for (Employee employee:employeeList) {
            if (employee.getId()== e.getId()) {
                employee = e;
                return e;
            }
        }
        employeeList.add(e);
        return e;
    }

    public void clearList(){employeeList.clear();}
}
