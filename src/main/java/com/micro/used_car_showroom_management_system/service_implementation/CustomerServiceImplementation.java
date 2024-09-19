package com.micro.used_car_showroom_management_system.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.repository.CustomerRepository;
import com.micro.used_car_showroom_management_system.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService {

	CustomerRepository repo;

	public CustomerServiceImplementation(CustomerRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer loginCustomer(String email, String password) {
		return repo.login(email, password);
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		return repo.listAllCustomers();
	}

	@Override
	public Customer fetchSingleCustomer(long id) {
		return repo.findCustomerById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return repo.update(customer);
	}

}
