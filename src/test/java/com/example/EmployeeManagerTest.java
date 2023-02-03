package com.example;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeManagerTest {

    public BankServiceinterface bankServiceinterface;

    public EmployeeRepositoryinterface employeeRepositoryinterface;

    public EmployeeManager employeeManager;
    public static List<Employee> employees = new ArrayList<>();


    @BeforeAll
    public void initialize() {
        this.bankServiceinterface = mock(BankServiceinterface.class);
        this.employeeRepositoryinterface = Mockito.mock(EmployeeRepositoryinterface.class);
        this.employeeManager = new EmployeeManager(employeeRepositoryinterface, bankServiceinterface);

        employees.add(new Employee("Emma", 45000));
        employees.add(new Employee("Aaron", 44000));

    }

    @Test
    public void payEmployeeShouldBeSuccessful() {

        when(employeeRepositoryinterface.findAll()).thenReturn(employees);
        assertEquals(2, employeeManager.payEmployees());
    }


}