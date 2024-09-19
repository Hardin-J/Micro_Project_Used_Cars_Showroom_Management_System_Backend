package com.micro.used_car_showroom_management_system.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.used_car_showroom_management_system.model.CarSales;
import com.micro.used_car_showroom_management_system.repository.CarSalesRepository;
import com.micro.used_car_showroom_management_system.service.CarSalesService;

@Service
public class CarSalesServiceImplementation implements CarSalesService{

	CarSalesRepository repo;
	
	public CarSalesServiceImplementation(CarSalesRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public CarSales addNewCarSales(CarSales carSales) {
		return repo.save(carSales);
	}

	@Override
	public CarSales updateCarSales(CarSales carSales) {		
		return repo.update(carSales);
	}

	@Override
	public CarSales getSingleCarSalesById(long id) {		
		return repo.getCarSalesById(id);
	}

	@Override
	public List<CarSales> getSingleCarCarSalesByCarId(long id) {
		return repo.getCarSalesByCarId(id);
	}

	@Override
	public List<CarSales> getSingleCustomerCarSalesByCustomerId(long id) {
		return repo.getCarSalesByCustomerId(id);
	}

	@Override
	public List<CarSales> getAllCarSales() {		
		return repo.fetchAllCarSales();
	}

}
