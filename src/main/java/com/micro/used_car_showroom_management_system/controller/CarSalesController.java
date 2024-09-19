package com.micro.used_car_showroom_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.used_car_showroom_management_system.mail_service.MailService;
import com.micro.used_car_showroom_management_system.model.CarSales;
import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.repository.CarRepository;
import com.micro.used_car_showroom_management_system.repository.CustomerRepository;
import com.micro.used_car_showroom_management_system.service.CarSalesService;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/carSales")
public class CarSalesController {
	
	CarSalesService service;
	CarRepository carRepository;
	CustomerRepository customerRepository;
	MailService mailService;

	public CarSalesController(CarSalesService service, CarRepository carRepository,
			CustomerRepository customerRepository, MailService mailService) {
		super();
		this.service = service;
		this.carRepository = carRepository;
		this.customerRepository = customerRepository;
		this.mailService = mailService;
	}

	@PostMapping
	public CarSales doAddNewCarSales(@RequestBody CarSales carSales) throws MessagingException {
		CarSales cSales = new CarSales();
		Cars cars = carRepository.getCarById(carSales.getCars().getId());
		cSales.setCars(cars);
		Customer customer = customerRepository.findCustomerById(carSales.getCustomer().getId()); 
		cSales.setCustomer(customer);
		cSales.setPrice(carSales.getPrice());
		mailService.sendPurchaseBookingConfirmation(customer.getEmail(), customer.getCustomerName(), cars, carSales.getPrice());
		mailService.sendPurchaseBookingNotificationToAdmin(customer.getCustomerName(), cars, carSales.getPrice());
		return service.addNewCarSales(cSales);
	}
	
	@GetMapping("/customer/{id}")
	public List<CarSales> doFetchAllBookingsForCustomerById(@PathVariable("id") long id){
		return service.getSingleCustomerCarSalesByCustomerId(id);
	}
	
	@GetMapping("/all")
	public List<CarSales> doFetchAllAvailableCarSales(){
		return service.getAllCarSales();
	}
	
	@PatchMapping("/approval/{id}")
	public CarSales doChangeCarSalesStatus(@PathVariable("id") long id,@RequestBody CarSales carSales) throws MessagingException {
		CarSales cSales = service.getSingleCarSalesById(id);
		String sts = carSales.getApprovalStatus();
		Customer customer = cSales.getCustomer();
		cSales.setApprovalStatus(sts);
		
		if(sts.equalsIgnoreCase("Approved")) {
			mailService.sendPurchaseOfferAcceptedNotification(customer.getEmail(), customer.getCustomerName(), cSales.getCars(), cSales.getPrice());
		} else {
			mailService.sendPurchaseOfferRejectedNotification(customer.getEmail(), customer.getCustomerName(), cSales.getCars(), cSales.getPrice());			
		}
		return service.updateCarSales(cSales);
	}

}
