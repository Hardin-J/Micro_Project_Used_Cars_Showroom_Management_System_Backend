package com.micro.used_car_showroom_management_system.repository_implementation;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.CarAdditionalInfo;
import com.micro.used_car_showroom_management_system.repository.CarAdditionalInfoRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarAdditionalInfoRepositoryImplementation implements CarAdditionalInfoRepository{

	EntityManager em;
	
	public CarAdditionalInfoRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public CarAdditionalInfo save(CarAdditionalInfo carAdditionalInfo) {
		try {
			em.persist(carAdditionalInfo);
		} catch (Exception e) {
			carAdditionalInfo = null;
		}
		return carAdditionalInfo;
	}

	@Override
	public CarAdditionalInfo carAdditionalInfoFindById(long id) {
		return em.find(CarAdditionalInfo.class, id);
	}

}
