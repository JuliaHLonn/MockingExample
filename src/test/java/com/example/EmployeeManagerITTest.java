package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeManagerITTest {

    private EmployeeManager employeeManager;
    private BankServiceinterface bankServiceinterface;

    List<Employee> employeeList = new ArrayList<>();

    @BeforeAll
    public void initialize(){
        bankServiceinterface = mock(BankServiceinterface.class);
        employeeList.add(new Employee("21", 34000));
        employeeList.add(new Employee("22", 35000));
        employeeList.add(new Employee("23", 36000));
        employeeList.add(new Employee("24", 37000));
    }
    @Test
    public void payEmployeesShouldWork(){
        employeeManager = new EmployeeManager(new InMemoryEmployeeRepository(employeeList),bankServiceinterface);
        assertEquals(4, employeeManager.payEmployees());
    }

}