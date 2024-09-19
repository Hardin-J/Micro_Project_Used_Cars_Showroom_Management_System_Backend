package com.micro.used_car_showroom_management_system.repository;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.Feedback;

public interface FeedbackRepository {
	
	public Feedback save(Feedback feedback);

	public List<Feedback> fetchAllFeedbacksForSingleCar(long id);

}
