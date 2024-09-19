package com.micro.used_car_showroom_management_system.repository;

import java.util.List;

import com.micro.used_car_showroom_management_system.model.TestDriveAppointment;

public interface TestDriveAppointmentRepository {

	public TestDriveAppointment save(TestDriveAppointment testDriveAppointment);

	public List<TestDriveAppointment> listAllAppointmentsForSingleUser(long id);

	public List<TestDriveAppointment> listAllAppointmentsForSingleCar(long id);

	public List<TestDriveAppointment> listAllAppointments();

	public TestDriveAppointment findSingleAppointmentById(long id);

	public TestDriveAppointment updateCancelStatus(TestDriveAppointment testDriveAppointment);

	public long countOfAllAppointments();

}
