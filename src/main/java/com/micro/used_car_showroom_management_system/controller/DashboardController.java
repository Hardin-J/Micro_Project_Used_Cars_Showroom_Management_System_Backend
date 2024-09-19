package com.micro.used_car_showroom_management_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.used_car_showroom_management_system.repository.CarRepository;
import com.micro.used_car_showroom_management_system.repository.CarSalesRepository;
import com.micro.used_car_showroom_management_system.repository.CustomerRepository;
import com.micro.used_car_showroom_management_system.repository.TestDriveAppointmentRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin/dashboard")
public class DashboardController {

	CarRepository carRepository;
	CustomerRepository customerRepository;
	TestDriveAppointmentRepository testDriveAppointmentRepository;
	CarSalesRepository carSalesRepository;
	
	public DashboardController(CarRepository carRepository, CustomerRepository customerRepository,
			TestDriveAppointmentRepository testDriveAppointmentRepository, CarSalesRepository carSalesRepository) {
		super();
		this.carRepository = carRepository;
		this.customerRepository = customerRepository;
		this.testDriveAppointmentRepository = testDriveAppointmentRepository;
		this.carSalesRepository = carSalesRepository;
	}

	@GetMapping
	public List<Long> doCountsOfAllFields(){
		List<Long> count = new ArrayList<>();
		count.add(carRepository.countOfAllCars());
		count.add(customerRepository.countOfCustomers());
		count.add(testDriveAppointmentRepository.countOfAllAppointments());
		count.add(carSalesRepository.countOfAllBookings());
		return count;
	}
}
