package com.micro.used_car_showroom_management_system.service_implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.used_car_showroom_management_system.model.CarSales;
import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.repository.CarSalesRepository;

public class CarSalesServiceImplementationTest {

    @Mock
    private CarSalesRepository repo;

    @InjectMocks
    private CarSalesServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddNewCarSales() {
        Customer customer = new Customer(1L, "Jane Doe", "jane.doe@example.com", "password", "0987654321", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        CarSales carSales = new CarSales(1L, car, customer, LocalDate.now(), "60000", "Pending");

        when(repo.save(carSales)).thenReturn(carSales);

        CarSales result = service.addNewCarSales(carSales);

        assertNotNull(result);
        assertEquals("60000", result.getPrice());
        assertEquals("Pending", result.getApprovalStatus());
        assertEquals(car, result.getCars());
        assertEquals(customer, result.getCustomer());
    }

    @Test
    void testUpdateCarSales() {
        Customer customer = new Customer(1L, "Jane Doe", "jane.doe@example.com", "password", "0987654321", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        CarSales carSales = new CarSales(1L, car, customer, LocalDate.now(), "60000", "Pending");

        when(repo.update(carSales)).thenReturn(carSales);

        CarSales result = service.updateCarSales(carSales);

        assertNotNull(result);
        assertEquals("60000", result.getPrice());
        assertEquals("Pending", result.getApprovalStatus());
    }

    @Test
    void testGetSingleCarSalesById() {
        Customer customer = new Customer(1L, "Jane Doe", "jane.doe@example.com", "password", "0987654321", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        CarSales carSales = new CarSales(1L, car, customer, LocalDate.now(), "60000", "Pending");

        when(repo.getCarSalesById(1L)).thenReturn(carSales);

        CarSales result = service.getSingleCarSalesById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("60000", result.getPrice());
        assertEquals("Pending", result.getApprovalStatus());
    }

    @Test
    void testGetSingleCarSalesByCarId() {
        Customer customer = new Customer(1L, "Jane Doe", "jane.doe@example.com", "password", "0987654321", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        List<CarSales> carSalesList = new ArrayList<>();
        carSalesList.add(new CarSales(1L, car, customer, LocalDate.now(), "60000", "Pending"));

        when(repo.getCarSalesByCarId(1L)).thenReturn(carSalesList);

        List<CarSales> result = service.getSingleCarCarSalesByCarId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("60000", result.get(0).getPrice());
    }

    @Test
    void testGetSingleCustomerCarSalesByCustomerId() {
        Customer customer = new Customer(1L, "Jane Doe", "jane.doe@example.com", "password", "0987654321", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        List<CarSales> carSalesList = new ArrayList<>();
        carSalesList.add(new CarSales(1L, car, customer, LocalDate.now(), "60000", "Pending"));

        when(repo.getCarSalesByCustomerId(1L)).thenReturn(carSalesList);

        List<CarSales> result = service.getSingleCustomerCarSalesByCustomerId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("60000", result.get(0).getPrice());
    }

    @Test
    void testGetAllCarSales() {
        Customer customer = new Customer(1L, "Jane Doe", "jane.doe@example.com", "password", "0987654321", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        List<CarSales> carSalesList = new ArrayList<>();
        carSalesList.add(new CarSales(1L, car, customer, LocalDate.now(), "60000", "Pending"));

        when(repo.fetchAllCarSales()).thenReturn(carSalesList);

        List<CarSales> result = service.getAllCarSales();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("60000", result.get(0).getPrice());
    }
}
