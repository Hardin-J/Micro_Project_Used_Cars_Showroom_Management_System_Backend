package com.micro.used_car_showroom_management_system.repository;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.Cars;

public interface CarRepository {

	public Cars save(Cars car);

	public Cars update(Cars car);

	public Cars getCarById(long id);
	
	public Cars getCarByName(String name);

	public List<Cars> fetchAllCars();
	
	public long countOfAllCars();

}
