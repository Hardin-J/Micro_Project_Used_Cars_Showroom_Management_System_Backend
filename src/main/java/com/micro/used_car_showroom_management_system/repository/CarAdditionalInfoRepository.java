package com.micro.used_car_showroom_management_system.repository;

import com.micro.used_car_showroom_management_system.model.CarAdditionalInfo;

public interface CarAdditionalInfoRepository {
	public CarAdditionalInfo save(CarAdditionalInfo carAdditionalInfo);
	public CarAdditionalInfo carAdditionalInfoFindById(long id);

}
