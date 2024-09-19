package com.micro.used_car_showroom_management_system.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.CarSales;
import com.micro.used_car_showroom_management_system.repository.CarSalesRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarSalesRepositoryImplementation implements CarSalesRepository {

	EntityManager em;
	
	public CarSalesRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public CarSales save(CarSales car) {
		try {
			em.persist(car);
		} catch (Exception e) {
			car = null;
		}
		return car;
	}

	@Override
	public CarSales update(CarSales car) {
		CarSales oldCar = em.find(CarSales.class, car.getId());
		if (oldCar != null) {
			em.merge(car);
		} else {
			car = null;
		}
		return car;
	}

	@Override
	public CarSales getCarSalesById(long id) {		
		return em.find(CarSales.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarSales> getCarSalesByCarId(long id) {
		String hql = "select c from CarSales c where cars.id = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarSales> getCarSalesByCustomerId(long id) {
		// TODO Auto-generated method stub
		String hql = "select c from CarSales c where customer.id = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarSales> fetchAllCarSales() {
		String hql = "from CarSales";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public long countOfAllBookings() {
		String hql = "select count(tda) from CarSales tda";
	    Query query = em.createQuery(hql);
	    return (Long) query.getSingleResult();
	}

}
