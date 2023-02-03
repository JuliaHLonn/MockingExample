package com.example;

import java.util.List;

public interface EmployeeRepositoryinterface {

	List<Employee> findAll();

	Employee save(Employee e);
}
