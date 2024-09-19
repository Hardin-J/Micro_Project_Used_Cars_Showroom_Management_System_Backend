package com.micro.used_car_showroom_management_system.repository_implementation;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.CarDetails;
import com.micro.used_car_showroom_management_system.repository.CarDetailsRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarDetailsRepositoryImplementation implements CarDetailsRepository{

	EntityManager em;
	
	public CarDetailsRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public CarDetails save(CarDetails carDetails) {
		try {
			em.persist(carDetails);					
		} catch (Exception e) {
			carDetails = null;
		}
		return carDetails;
	}

	@Override
	public CarDetails CarDetailsFindById(long id) {		
		return em.find(CarDetails.class, id);
	}

}
