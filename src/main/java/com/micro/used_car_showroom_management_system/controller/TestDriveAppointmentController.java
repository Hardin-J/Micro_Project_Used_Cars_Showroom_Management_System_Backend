package com.micro.used_car_showroom_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.used_car_showroom_management_system.mail_service.MailService;
import com.micro.used_car_showroom_management_system.model.TestDriveAppointment;
import com.micro.used_car_showroom_management_system.service.TestDriveAppointmentService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/testDriveApp")
@CrossOrigin("http://localhost:3000")
public class TestDriveAppointmentController {

	TestDriveAppointmentService service;
	MailService mailService;

	public TestDriveAppointmentController(TestDriveAppointmentService service, MailService mailService) {
		super();
		this.service = service;
		this.mailService = mailService;
	}

	@PostMapping
	public TestDriveAppointment doAddNewAppointment(@RequestBody TestDriveAppointment testDriveAppointment)
			throws MessagingException {
		String msg1 = mailService.sendTestDriveBookingNotificationToAdmin(
				testDriveAppointment.getCustomer().getCustomerName(), testDriveAppointment.getSlot(),
				testDriveAppointment.getCars());
		System.out.println(msg1);
		String msg2 = mailService.sendTestDriveBookingAppointment(testDriveAppointment.getCustomer().getEmail(),
				testDriveAppointment.getCustomer().getCustomerName(), testDriveAppointment.getSlot(),
				testDriveAppointment.getCars());
		System.out.println(msg2);
		return service.addNewTestDriveAppointment(testDriveAppointment);
	}

	@GetMapping("/all")
	public List<TestDriveAppointment> doFetchAllAvailableAppointments() {
		return service.getAllAvailableAppointments();
	}

	@GetMapping("/appointments/customers/{id}")
	public List<TestDriveAppointment> doFetchAppointmentsForSingleUser(@PathVariable("id") long id) {
		return service.getAllAppointmentsForSingleUser(id);
	}

	@GetMapping("/appointments/cars/{id}")
	public List<TestDriveAppointment> doFetchAppointmentsForSingleCar(@PathVariable("id") long id) {
		return service.getAllAppointmentsForSingleCar(id);
	}

	@PatchMapping("/cancelAppointment/{id}")
	public TestDriveAppointment doCancelAppointment(@PathVariable("id") long id,@RequestParam("reason") String reason) throws MessagingException {
		TestDriveAppointment appointment = service.fetchAppointmentById(id);
		if(appointment != null) {
			appointment.setCancelReason(reason);
			appointment.setStatus("Cancelled");
			String msgString = mailService.sendTestDriveCancellationNotification(appointment.getCustomer().getEmail(), appointment.getCustomer().getCustomerName(), appointment.getCars(), appointment.getTestDriveDate(), appointment.getSlot(), reason);
			System.out.println(msgString);
			mailService.sendTestDriveCancellationToAdmin( appointment.getCustomer().getCustomerName(), appointment.getCars(), appointment.getTestDriveDate(), appointment.getSlot(), reason);
			return service.updateCancellationStatus(id, appointment);
		} else {
			return null;
		}
		
	}
	@PatchMapping("/completedAppointment/{id}")
	public TestDriveAppointment doCompleteAppointment(@PathVariable("id") long id) throws MessagingException {
		TestDriveAppointment appointment = service.fetchAppointmentById(id);
		if(appointment != null) {
			appointment.setStatus("Completed");
			return service.updateCancellationStatus(id, appointment);
		} else {
			return null;
		}
		
	}
}
