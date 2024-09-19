package com.micro.used_car_showroom_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.model.Feedback;
import com.micro.used_car_showroom_management_system.repository.CarRepository;
import com.micro.used_car_showroom_management_system.repository.CustomerRepository;
import com.micro.used_car_showroom_management_system.service.FeedbackService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	FeedbackService service;
	CarRepository carRepository;
	CustomerRepository customerRepository;
		
	public FeedbackController(FeedbackService service, CarRepository carRepository,
			CustomerRepository customerRepository) {
		super();
		this.service = service;
		this.carRepository = carRepository;
		this.customerRepository = customerRepository;
	}

	@PostMapping
	public Feedback doAddNewFeedback(@RequestBody Feedback feedback) {
		Feedback newFeedback = new Feedback();
		newFeedback.setRatings(feedback.getRatings());
		newFeedback.setReview(feedback.getReview());
		Cars car = carRepository.getCarById(feedback.getCars().getId());
		Customer customer = customerRepository.findCustomerById(feedback.getCustomer().getId());
		newFeedback.setCars(car);
		newFeedback.setCustomer(customer);		
		return service.addNewFeedback(newFeedback);
	}
	
	@GetMapping("/all/{id}")
	public List<Feedback> doFetchAllFeedbacksByCarId(@PathVariable("id") long id){
		return service.geteAllFeedbacksForSingleCar(id);
	}

}
