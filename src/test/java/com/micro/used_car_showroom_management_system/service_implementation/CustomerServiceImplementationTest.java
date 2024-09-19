package com.micro.used_car_showroom_management_system.service_implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.repository.CustomerRepository;

public class CustomerServiceImplementationTest {

    @Mock
    private CustomerRepository repo;

    @InjectMocks
    private CustomerServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer(1L, "Jeevarajan", "jeeva@example.com", "password", "1234567890", new Date());
        when(repo.save(customer)).thenReturn(customer);

        Customer result = service.addCustomer(customer);

        assertNotNull(result);
        assertEquals("Jeevarajan", result.getCustomerName());
    }

    @Test
    void testLoginCustomer() {
        Customer customer = new Customer(1L, "Jeevarajan", "jeeva@example.com", "password", "1234567890", new Date());
        when(repo.login("jeeva@example.com", "password")).thenReturn(customer);

        Customer result = service.loginCustomer("jeeva@example.com", "password");

        assertNotNull(result);
        assertEquals("Jeevarajan", result.getCustomerName());
    }

    @Test
    void testFetchAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "Jeevarajan", "jeeva@example.com", "password", "1234567890", new Date()));
        customers.add(new Customer(2L, "Jeeva", "jane@example.com", "password", "0987654321", new Date()));
        when(repo.listAllCustomers()).thenReturn(customers);

        List<Customer> result = service.fetchAllCustomers();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testFetchSingleCustomer() {
        Customer customer = new Customer(1L, "Jeevarajan", "jeeva@example.com", "password", "1234567890", new Date());
        when(repo.findCustomerById(1L)).thenReturn(customer);

        Customer result = service.fetchSingleCustomer(1L);

        assertNotNull(result);
        assertEquals("Jeevarajan", result.getCustomerName());
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer(1L, "Jeevarajan", "jeeva@example.com", "password", "1234567890", new Date());
        when(repo.update(customer)).thenReturn(customer);

        Customer result = service.updateCustomer(customer);

        assertNotNull(result);
        assertEquals("Jeevarajan", result.getCustomerName());
    }
}
