package com.micro.used_car_showroom_management_system.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.Feedback;
import com.micro.used_car_showroom_management_system.repository.FeedbackRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FeedbackRepositoryImplementation implements FeedbackRepository {

	EntityManager em;

	public FeedbackRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Feedback save(Feedback feedback) {
		em.persist(feedback);
		return feedback;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> fetchAllFeedbacksForSingleCar(long id) {
		String hql = "select fd from Feedback fd where cars.id = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}

}
