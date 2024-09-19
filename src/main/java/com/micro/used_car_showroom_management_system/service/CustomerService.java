package com.micro.used_car_showroom_management_system.service;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);

	public Customer loginCustomer(String email, String password);
	
	public Customer fetchSingleCustomer(long id);

	public List<Customer> fetchAllCustomers();

}
