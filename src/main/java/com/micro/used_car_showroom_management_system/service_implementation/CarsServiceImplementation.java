package com.micro.used_car_showroom_management_system.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.repository.CarRepository;
import com.micro.used_car_showroom_management_system.service.CarsService;

@Service
public class CarsServiceImplementation implements CarsService{

	CarRepository repo;
	
	public CarsServiceImplementation(CarRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Cars addNewCars(Cars cars) {
		return repo.save(cars);
	}

	@Override
	public List<Cars> fetchAllCars() {
		return repo.fetchAllCars();
	}

	@Override
	public Cars getSingleCar(long id) {
		return repo.getCarById(id);
	}

	@Override
	public Cars addUpdateCar(Cars cars) {
		return repo.update(cars);
	}

}
