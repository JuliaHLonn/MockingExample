package com.example;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeManagerTest {


    public EmployeeRepositoryinterface employeeRepositoryinterface;

    public EmployeeManager employeeManager;

    public BankServiceDummy bankServiceDummy;
    public static List<Employee> employees = new ArrayList<>();


    @BeforeAll
    public void initialize() {
        this.employeeRepositoryinterface = Mockito.mock(EmployeeRepositoryinterface.class);
        this.bankServiceDummy = new BankServiceDummy();
        this.employeeManager = new EmployeeManager(employeeRepositoryinterface, bankServiceDummy);



    }

    @Test
    @Order(1)
    public void payEmployeeShouldBeSuccessful() {
        employees.add(new Employee("1", 45000));
        employees.add(new Employee("2", 44000));
        when(employeeRepositoryinterface.findAll()).thenReturn(employees);
        assertEquals(2, employeeManager.payEmployees());
    }

    @Test
    public void payEmployeesShouldFailBecauseNoEmployees() {
        when(employeeRepositoryinterface.findAll()).thenReturn(null);
        assertThrows(RuntimeException.class, () -> {
            employeeManager.payEmployees();
        });
    }


    @Test
    @Order(2)
    public void checkIfSpecificEmployeeIsPaid() {
        Employee emma = new Employee("5", 15000);
        employees.add(emma);
        when(employeeRepositoryinterface.findAll()).thenReturn(employees);
        employeeManager.payEmployees();
        assertTrue(emma.isPaid());

    }

    @Test
    public void allEmployeesShouldBePaidByUsingDummiesOnly() {
        EmployeeManager employeeManager1 = new EmployeeManager(new EmployeeRepositoryStub(), bankServiceDummy);
        assertEquals(3, employeeManager1.payEmployees());
    }

}
