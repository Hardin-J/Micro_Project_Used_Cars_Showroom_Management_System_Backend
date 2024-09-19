package com.micro.used_car_showroom_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Test_drive_appointment_tbl")
public class TestDriveAppointment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Test_drive_appointment_id")
	private long id;
	
	@Column(name = "Test_drive_date")
	private String testDriveDate;
	
	// status like approved or cancelled
	@Column
	private String status;
	
	@Column(nullable = true)
	private String cancelReason;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	@ManyToOne
	@JoinColumn
	private Cars cars;
	
	@Column
	private String slot;

	public TestDriveAppointment() {
		super();
	}

	public TestDriveAppointment(long id, String testDriveDate, String status, String cancelReason, Customer customer,
			Cars cars, String slot) {
		super();
		this.id = id;
		this.testDriveDate = testDriveDate;
		this.status = status;
		this.cancelReason = cancelReason;
		this.customer = customer;
		this.cars = cars;
		this.slot = slot;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTestDriveDate() {
		return testDriveDate;
	}

	public void setTestDriveDate(String testDriveDate) {
		this.testDriveDate = testDriveDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cars getCars() {
		return cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}	
}
