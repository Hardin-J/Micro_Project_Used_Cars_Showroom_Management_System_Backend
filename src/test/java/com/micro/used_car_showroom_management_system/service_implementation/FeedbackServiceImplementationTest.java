//package com.micro.used_car_showroom_management_system.service_implementation;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class FeedbackServiceImplementationTest {
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}

package com.micro.used_car_showroom_management_system.service_implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.model.Feedback;
import com.micro.used_car_showroom_management_system.repository.FeedbackRepository;

public class FeedbackServiceImplementationTest {

    @Mock
    private FeedbackRepository repo;

    @InjectMocks
    private FeedbackServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddNewFeedback() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        Feedback feedback = new Feedback(1L, "Excellent car!", 5, car, customer, LocalTime.now(), LocalDate.now());
        
        when(repo.save(feedback)).thenReturn(feedback);

        Feedback result = service.addNewFeedback(feedback);

        assertNotNull(result);
        assertEquals("Excellent car!", result.getReview());
        assertEquals(5, result.getRatings());
        assertEquals(car, result.getCars());
        assertEquals(customer, result.getCustomer());
    }

    @Test
    void testGetAllFeedbacksForSingleCar() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password", "1234567890", null);
        Cars car = new Cars(1L, "BMW", "X5", "60000", "Munich", "2024", "Available", null, null);
        List<Feedback> feedbacks = new ArrayList<>();
        feedbacks.add(new Feedback(1L, "Excellent car!", 5, car, customer, LocalTime.now(), LocalDate.now()));
        feedbacks.add(new Feedback(2L, "Good performance.", 4, car, customer, LocalTime.now(), LocalDate.now()));

        when(repo.fetchAllFeedbacksForSingleCar(1L)).thenReturn(feedbacks);

        List<Feedback> result = service.geteAllFeedbacksForSingleCar(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Excellent car!", result.get(0).getReview());
        assertEquals(4, result.get(1).getRatings());
    }

}
