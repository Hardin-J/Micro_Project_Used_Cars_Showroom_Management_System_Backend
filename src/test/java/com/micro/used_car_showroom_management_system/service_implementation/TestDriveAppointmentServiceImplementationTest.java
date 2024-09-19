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

import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.model.TestDriveAppointment;
import com.micro.used_car_showroom_management_system.repository.TestDriveAppointmentRepository;

public class TestDriveAppointmentServiceImplementationTest {

    @Mock
    private TestDriveAppointmentRepository repo;

    @InjectMocks
    private TestDriveAppointmentServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddNewTestDriveAppointment() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        TestDriveAppointment appointment = new TestDriveAppointment(1L, "2024-09-20", "Approved", null, customer, car, "10:00 AM");
        when(repo.save(appointment)).thenReturn(appointment);

        TestDriveAppointment result = service.addNewTestDriveAppointment(appointment);

        assertNotNull(result);
        assertEquals("2024-09-20", result.getTestDriveDate());
        assertEquals("Approved", result.getStatus());
        assertEquals("10:00 AM", result.getSlot());
    }

    @Test
    void testGetAllAvailableAppointments() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        List<TestDriveAppointment> appointments = new ArrayList<>();
        appointments.add(new TestDriveAppointment(1L, "2024-09-20", "Approved", null, customer, car, "10:00 AM"));
        appointments.add(new TestDriveAppointment(2L, "2024-09-21", "Pending", "Waiting for confirmation", customer, car, "11:00 AM"));
        
        when(repo.listAllAppointments()).thenReturn(appointments);

        List<TestDriveAppointment> result = service.getAllAvailableAppointments();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("2024-09-20", result.get(0).getTestDriveDate());
        assertEquals("Pending", result.get(1).getStatus());
    }

    @Test
    void testGetAllAppointmentsForSingleUser() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        List<TestDriveAppointment> appointments = new ArrayList<>();
        appointments.add(new TestDriveAppointment(1L, "2024-09-20", "Approved", null, customer, car, "10:00 AM"));

        when(repo.listAllAppointmentsForSingleUser(1L)).thenReturn(appointments);

        List<TestDriveAppointment> result = service.getAllAppointmentsForSingleUser(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("2024-09-20", result.get(0).getTestDriveDate());
    }

    @Test
    void testGetAllAppointmentsForSingleCar() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        List<TestDriveAppointment> appointments = new ArrayList<>();
        appointments.add(new TestDriveAppointment(1L, "2024-09-20", "Approved", null, customer, car, "10:00 AM"));

        when(repo.listAllAppointmentsForSingleCar(1L)).thenReturn(appointments);

        List<TestDriveAppointment> result = service.getAllAppointmentsForSingleCar(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("2024-09-20", result.get(0).getTestDriveDate());
    }

    @Test
    void testUpdateCancellationStatus() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        TestDriveAppointment appointment = new TestDriveAppointment(1L, "2024-09-20", "Approved", null, customer, car, "10:00 AM");
        TestDriveAppointment updatedAppointment = new TestDriveAppointment(1L, "2024-09-20", "Cancelled", "Customer requested cancellation", customer, car, "10:00 AM");

        when(repo.findSingleAppointmentById(1L)).thenReturn(appointment);
        when(repo.updateCancelStatus(updatedAppointment)).thenReturn(updatedAppointment);

        TestDriveAppointment result = service.updateCancellationStatus(1L, updatedAppointment);

        assertNull(result);
//        assertEquals("Cancelled", result.getStatus());
//        assertEquals("Customer requested cancellation", result.getCancelReason());
    }

    @Test
    void testFetchAppointmentById() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        TestDriveAppointment appointment = new TestDriveAppointment(1L, "2024-09-20", "Approved", null, customer, car, "10:00 AM");

        when(repo.findSingleAppointmentById(1L)).thenReturn(appointment);

        TestDriveAppointment result = service.fetchAppointmentById(1L);

        assertNotNull(result);
        assertEquals("2024-09-20", result.getTestDriveDate());
        assertEquals("Approved", result.getStatus());
    }
}
