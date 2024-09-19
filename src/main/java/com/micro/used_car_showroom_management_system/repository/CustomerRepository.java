package com.micro.used_car_showroom_management_system.repository;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.Customer;

public interface CustomerRepository {

	public Customer save(Customer customer);

	public Customer update(Customer customer);

	public String delete(int id);

	public Customer findCustomerById(long id);

	public Customer findCustomerByName(String name);

	public List<Customer> listAllCustomers();
	
	public long countOfCustomers();

	public Customer login(String email, String password);

}
