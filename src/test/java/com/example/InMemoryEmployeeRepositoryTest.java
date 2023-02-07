package com.example;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InMemoryEmployeeRepositoryTest {

    public InMemoryEmployeeRepository inMemoryEmployeeRepository;
    Employee employee1;
    Employee employee2;
    Employee employee3;

    @BeforeAll
    public void initialize() {
        this.inMemoryEmployeeRepository = new InMemoryEmployeeRepository();
        employee1 = new Employee("8", 28000);
        employee2 = new Employee("9", 29000);
        employee3 = new Employee("14", 30000);
    }

    @Test
    void findAllShouldReturnListOfEmployees() {
        inMemoryEmployeeRepository.save(employee1);
        inMemoryEmployeeRepository.save(employee2);
        inMemoryEmployeeRepository.save(employee3);
        assertTrue(inMemoryEmployeeRepository.findAll().contains(employee1));
        assertTrue(inMemoryEmployeeRepository.findAll().contains(employee2));
        assertTrue(inMemoryEmployeeRepository.findAll().contains(employee3));
    }

    @Test
    void saveShouldSaveEmployeeToEmployeeListAndReplaceIfEmployeeHasSameId() {
        inMemoryEmployeeRepository.clearList();
        Employee karl = new Employee("10", 65000);
        Employee kalle = new Employee("10", 65000);
        inMemoryEmployeeRepository.save(karl);
        inMemoryEmployeeRepository.save(kalle);
        assertEquals(1, inMemoryEmployeeRepository.findAll().size());

    }

    @Test
    void saveShouldSaveEmployeeToEmployeeListAndFindAllShouldReturnThatList() {
        inMemoryEmployeeRepository.save(employee1);
        inMemoryEmployeeRepository.save(employee2);
        assertEquals(2, inMemoryEmployeeRepository.findAll().size());
    }

    @Test
    void saveShouldSaveEmployeeToEmployeeListAndReturnTheSameObject() {
        inMemoryEmployeeRepository.save(employee3);
        assertSame(employee3, inMemoryEmployeeRepository.save(employee3));
    }


}