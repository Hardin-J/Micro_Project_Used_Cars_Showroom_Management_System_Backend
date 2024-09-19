package com.micro.used_car_showroom_management_system.service;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.CarSales;

public interface CarSalesService {

	public CarSales addNewCarSales(CarSales carSales);

	public CarSales updateCarSales(CarSales carSales);

	public CarSales getSingleCarSalesById(long id);

	public List<CarSales> getSingleCarCarSalesByCarId(long id);

	public List<CarSales> getSingleCustomerCarSalesByCustomerId(long id);
	
	public List<CarSales> getAllCarSales();

}
