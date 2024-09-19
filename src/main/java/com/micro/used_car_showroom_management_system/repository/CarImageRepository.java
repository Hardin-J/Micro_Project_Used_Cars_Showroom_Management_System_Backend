package com.micro.used_car_showroom_management_system.repository;

import com.micro.used_car_showroom_management_system.model.CarImage;

public interface CarImageRepository {

	public CarImage save(CarImage carImage);	
	public CarImage CarImageFindById(long id);


}
