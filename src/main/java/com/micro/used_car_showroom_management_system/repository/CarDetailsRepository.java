package com.micro.used_car_showroom_management_system.repository;

import com.micro.used_car_showroom_management_system.model.CarDetails;

public interface CarDetailsRepository {
	
	public CarDetails save(CarDetails carDetails);
	public CarDetails CarDetailsFindById(long id);


}
