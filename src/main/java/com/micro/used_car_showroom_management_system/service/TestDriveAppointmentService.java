package com.micro.used_car_showroom_management_system.service;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.TestDriveAppointment;

public interface TestDriveAppointmentService {

	public TestDriveAppointment addNewTestDriveAppointment(TestDriveAppointment testDriveAppointment);

	public List<TestDriveAppointment> getAllAvailableAppointments();

	public List<TestDriveAppointment> getAllAppointmentsForSingleUser(long id);

	public List<TestDriveAppointment> getAllAppointmentsForSingleCar(long id);
	
	public TestDriveAppointment updateCancellationStatus(long id, TestDriveAppointment appointment);
	
	public TestDriveAppointment fetchAppointmentById(long id);

}
