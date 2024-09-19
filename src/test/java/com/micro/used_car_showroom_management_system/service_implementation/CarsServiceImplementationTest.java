package com.micro.used_car_showroom_management_system.service_implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.repository.CarRepository;

public class CarsServiceImplementationTest {

    @Mock
    private CarRepository repo;

    @InjectMocks
    private CarsServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddNewCars() {
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        when(repo.save(car)).thenReturn(car);

        Cars result = service.addNewCars(car);

        assertNotNull(result);
        assertEquals("BMW", result.getMake());
        assertEquals("X5", result.getModel());
        assertEquals("60000", result.getPrice());
        assertEquals("Munich", result.getLocation());
        assertEquals("2024", result.getYrOfManufacture());
    }

    @Test
    void testFetchAllCars() {
        List<Cars> cars = new ArrayList<>();
        cars.add(new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null));
        cars.add(new Cars(2L, "BMW", "3 Series", "45000", "Berlin", "2023", "Available", null, null));
        
        when(repo.fetchAllCars()).thenReturn(cars);

        List<Cars> result = service.fetchAllCars();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("BMW", result.get(0).getMake());
        assertEquals("X5", result.get(0).getModel());
        assertEquals("BMW", result.get(1).getMake());
        assertEquals("3 Series", result.get(1).getModel());
    }

    @Test
    void testGetSingleCar() {
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        when(repo.getCarById(1L)).thenReturn(car);

        Cars result = service.getSingleCar(1L);

        assertNotNull(result);
        assertEquals("BMW", result.getMake());
        assertEquals("X5", result.getModel());
    }

    @Test
    void testAddUpdateCar() {
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        when(repo.update(car)).thenReturn(car);

        Cars result = service.addUpdateCar(car);

        assertNotNull(result);
        assertEquals("BMW", result.getMake());
        assertEquals("X5", result.getModel());
        assertEquals("60000", result.getPrice());
    }
}
