package com.micro.used_car_showroom_management_system.service;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.Feedback;

public interface FeedbackService {
	
	public Feedback addNewFeedback(Feedback feedback);

	public List<Feedback> geteAllFeedbacksForSingleCar(long id);

}
