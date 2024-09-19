package com.micro.used_car_showroom_management_system.repository;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.CarSales;

public interface CarSalesRepository {

	public CarSales save(CarSales car);

	public CarSales update(CarSales car);

	public CarSales getCarSalesById(long id);

	public List<CarSales> getCarSalesByCarId(long id);

	public List<CarSales> getCarSalesByCustomerId(long id);

	public List<CarSales> fetchAllCarSales();
	
	public long countOfAllBookings();

}
