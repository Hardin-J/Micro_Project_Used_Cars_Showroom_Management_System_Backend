package com.micro.used_car_showroom_management_system.service;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.Cars;

public interface CarsService {

	public Cars addNewCars(Cars cars);
	
	public Cars addUpdateCar(Cars cars);

	public Cars getSingleCar(long id);

	public List<Cars> fetchAllCars();

}
