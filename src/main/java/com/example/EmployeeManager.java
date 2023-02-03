package com.example;

import java.util.List;


public class EmployeeManager {

	private final EmployeeRepositoryinterface employeeRepositoryinterface;
	private final BankServiceinterface bankServiceinterface;

	public EmployeeManager(EmployeeRepositoryinterface employeeRepositoryinterface, BankServiceinterface bankServiceinterface) {
		this.employeeRepositoryinterface = employeeRepositoryinterface;
		this.bankServiceinterface = bankServiceinterface;
	}

	public int payEmployees() {
		List<Employee> employees = employeeRepositoryinterface.findAll();
		int payments = 0;
		for (Employee employee : employees) {
			try {
				bankServiceinterface.pay(employee.getId(), employee.getSalary());
				employee.setPaid(true);
				payments++;
			} catch (RuntimeException e) {
				employee.setPaid(false);
			}
		}
		return payments;
	}
}
