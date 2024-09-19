package com.micro.used_car_showroom_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cars_details_tbl")
public class CarDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Car_details_id")
	private long id;
	
	@Column(name = "Body_type")
	private String bodyType;

	@Column(name = "Kms_driven")
	private String kmsDriven;

	@Column(name = "Fuel_type")
	private String fuelType;

	@Column(name = "Color")
	private String color;

	@Column(name = "Transmission")
	private String transmission;
	
	@Column(name = "Registered_year")
	private String regYear;

	@Column(name = "Seats")
	private String seats;

	@Column(name = "Engine_displacement")
	private String engineDisplacement;

	public CarDetails() {
		super();
	}

	public CarDetails(long id, String bodyType, String kmsDriven, String fuelType, String color, String transmission,
			String regYear, String seats, String engineDisplacement) {
		super();
		this.id = id;
		this.bodyType = bodyType;
		this.kmsDriven = kmsDriven;
		this.fuelType = fuelType;
		this.color = color;
		this.transmission = transmission;
		this.regYear = regYear;
		this.seats = seats;
		this.engineDisplacement = engineDisplacement;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getKmsDriven() {
		return kmsDriven;
	}

	public void setKmsDriven(String kmsDriven) {
		this.kmsDriven = kmsDriven;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getRegYear() {
		return regYear;
	}

	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(String engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}
}