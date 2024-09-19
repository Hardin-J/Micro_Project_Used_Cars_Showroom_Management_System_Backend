package com.micro.used_car_showroom_management_system.repository_implementation;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.Owner;
import com.micro.used_car_showroom_management_system.repository.OwnerRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OwnerRepositoryImplementation implements OwnerRepository{

	EntityManager em;
	
	public OwnerRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Owner save(Owner owner) {
		try {
			em.persist(owner);
		} catch (Exception e) {
			owner = null;
		}
		return owner;
	}

}
