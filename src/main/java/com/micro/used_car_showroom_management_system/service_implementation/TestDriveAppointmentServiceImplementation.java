package com.micro.used_car_showroom_management_system.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.used_car_showroom_management_system.model.TestDriveAppointment;
import com.micro.used_car_showroom_management_system.repository.TestDriveAppointmentRepository;
import com.micro.used_car_showroom_management_system.service.TestDriveAppointmentService;

@Service
public class TestDriveAppointmentServiceImplementation implements TestDriveAppointmentService{

	TestDriveAppointmentRepository repo;
	
	public TestDriveAppointmentServiceImplementation(TestDriveAppointmentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public TestDriveAppointment addNewTestDriveAppointment(TestDriveAppointment testDriveAppointment) {
		return repo.save(testDriveAppointment);
	}

	@Override
	public List<TestDriveAppointment> getAllAvailableAppointments() {		
		return repo.listAllAppointments();
	}

	@Override
	public List<TestDriveAppointment> getAllAppointmentsForSingleUser(long id) {		
		return repo.listAllAppointmentsForSingleUser(id);
	}

	@Override
	public List<TestDriveAppointment> getAllAppointmentsForSingleCar(long id) {		
		return repo.listAllAppointmentsForSingleCar(id);
	}

	@Override
	public TestDriveAppointment updateCancellationStatus(long id, TestDriveAppointment appointment) {
		TestDriveAppointment testDriveAppointment = repo.findSingleAppointmentById(id);
		if(testDriveAppointment != null) {
			return repo.updateCancelStatus(testDriveAppointment);
		}
		return null;
	}

	@Override
	public TestDriveAppointment fetchAppointmentById(long id) {
		return repo.findSingleAppointmentById(id);
	}

}
