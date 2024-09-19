package com.micro.used_car_showroom_management_system.repository_implementation;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.CarImage;
import com.micro.used_car_showroom_management_system.repository.CarImageRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarImageRepositoryImplementation implements CarImageRepository{

	EntityManager em;
	
	public CarImageRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public CarImage save(CarImage carImage) {
		try {
			em.persist(carImage);			
		} catch (Exception e) {
			carImage = null;
		}
		return carImage;
	}

	@Override
	public CarImage CarImageFindById(long id) {
		return em.find(CarImage.class, id);
	}
	
}
