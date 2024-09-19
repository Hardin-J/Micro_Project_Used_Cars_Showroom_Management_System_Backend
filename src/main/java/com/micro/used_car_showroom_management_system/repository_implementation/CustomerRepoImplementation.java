package com.micro.used_car_showroom_management_system.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.Customer;
import com.micro.used_car_showroom_management_system.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImplementation implements CustomerRepository {

	EntityManager em;

	public CustomerRepoImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Customer save(Customer customer) {
		try {
			em.persist(customer);
		} catch (Exception e) {
			e.printStackTrace();
//			customer = null;
		}
		return customer;
	}

	@Override
	public Customer update(Customer newCustomer) {
		Customer oldCustomer = em.find(Customer.class, newCustomer.getId());
		if (oldCustomer!= null) {
			try {
				em.merge(newCustomer);
			} catch (Exception e) {
				newCustomer = null;
			}
		} else {
			newCustomer = null;
		}
		return newCustomer;
	}

	@Override
	public String delete(int id) {
		String msg = "";
		Customer customer = em.find(Customer.class, id);
		if (customer != null) {
			try {
				em.remove(customer);
				msg = "Customer Removed Successfully";
			} catch (Exception e) {
				msg = "Customer removed Unsuccessfully";
			}
		} else {
			msg = "Customer Not found";
		}
		return msg;
	}

	@Override
	public Customer findCustomerById(long id) {
		Customer customer = em.find(Customer.class, id);
		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}

	@Override
	public Customer findCustomerByName(String name) {
		String hql = "select cust from Customer cust where cust.customerName = :name";
		Customer customer;
		try {
			Query query = em.createQuery(hql).setParameter("name", name);
			customer = (Customer) query.getSingleResult();

		} catch (Exception e) {
			customer = null;
		}
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listAllCustomers() {
		String hql = "from Customer";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Customer login(String email, String password) {
		Customer cs;
		String hql = "select cust from Customer cust where email = :email and password = :password ";
		Query query = em.createQuery(hql).setParameter("email", email).setParameter("password", password);
		try {
			cs = (Customer) query.getSingleResult();
		} catch (Exception e) {
			cs = null;
		}
		return cs;
	}

	@Override
	public long countOfCustomers() {
		String hql = "select count(tda) from Customer tda";
	    Query query = em.createQuery(hql);
	    return (Long) query.getSingleResult();
	}

}
