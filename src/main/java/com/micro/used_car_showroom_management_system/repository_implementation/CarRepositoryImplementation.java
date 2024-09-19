package com.micro.used_car_showroom_management_system.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.repository.CarRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarRepositoryImplementation implements CarRepository {

	EntityManager em;

	public CarRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Cars save(Cars car) {
		try {
			em.persist(car);
		} catch (Exception e) {
			car = null;
		}
		return car;
	}

	@Override
	public Cars update(Cars car) {
		Cars oldCar = em.find(Cars.class, car.getId());
		if (oldCar != null) {
			em.merge(car);
		} else {
			car = null;
		}
		return car;
	}

	@Override
	public Cars getCarById(long id) {
		Cars car = em.find(Cars.class, id);
		return car;
	}

	@Override
	public Cars getCarByName(String name) {
		String hql = "select c from Cars where model = :name";
		Query query = em.createQuery(hql).setParameter("name", name);
		return (Cars)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cars> fetchAllCars() {
		String hql = "from Cars";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public long countOfAllCars() {
		String hql = "select count(tda) from Cars tda";
	    Query query = em.createQuery(hql);
	    return (Long) query.getSingleResult();
	}

}
