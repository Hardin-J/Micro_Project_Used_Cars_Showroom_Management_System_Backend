package com.micro.used_car_showroom_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.used_car_showroom_management_system.mail_service.MailService;
import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.service.CustomerService;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;
	private MailService mailService;

	public CustomerController(CustomerService service, MailService mailService) {
		super();
		this.service = service;
		this.mailService = mailService;
	}

	@PostMapping
	public Customer doAddNewCustomer(@RequestBody Customer customer) throws MessagingException {
		mailService.sendRegistrationConfirmation(customer.getEmail(), customer.getCustomerName());
		return service.addCustomer(customer);
	}

	@PutMapping("/{id}")
	public Customer doUpdateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		Customer oldCustomer = service.fetchSingleCustomer(id);
		if (oldCustomer != null) {
			return service.updateCustomer(customer);
		} else {
			return oldCustomer;
		}
	}

	@PostMapping("/login/{email}/{password}")
	public Customer doLoginCustomer(@PathVariable("email") String email, @PathVariable("password") String password) {
		return service.loginCustomer(email, password);
	}

	@GetMapping("/all")
	public List<Customer> doFetchAllCustomers() {
		return service.fetchAllCustomers();
	}

	@GetMapping("/{id}")
	public Customer doFetchSingleUser(@PathVariable long id) {
		return service.fetchSingleCustomer(id);
	}

}
