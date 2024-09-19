package com.micro.used_car_showroom_management_system.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.used_car_showroom_management_system.model.Feedback;
import com.micro.used_car_showroom_management_system.repository.FeedbackRepository;
import com.micro.used_car_showroom_management_system.service.FeedbackService;

@Service
public class FeedbackServiceImplementation implements FeedbackService{

	FeedbackRepository repo;
	
	public FeedbackServiceImplementation(FeedbackRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Feedback addNewFeedback(Feedback feedback) {		
		return repo.save(feedback);
	}

	@Override
	public List<Feedback> geteAllFeedbacksForSingleCar(long id) {		
		return repo.fetchAllFeedbacksForSingleCar(id);
	}

}
