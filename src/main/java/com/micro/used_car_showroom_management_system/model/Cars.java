package com.micro.used_car_showroom_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cars_tbl")
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Car_id")
	private long id;

	@Column(name = "Make")
	private String make;

	@Column(name = "Model")
	private String model;

	@Column(name = "Price")
	private String price;

	@Column(name = "Location")
	private String location;

	@Column(name = "Year_of_manufacture")
	private String yrOfManufacture;

	@Column
	private String soldStatus = "Available";

	@OneToOne
	private CarDetails carDetails;

	@OneToOne
	private CarAdditionalInfo carAdditionalInfo;

	public Cars() {
		super();
	}

	public Cars(long id, String make, String model, String price, String location, String yrOfManufacture,
			String soldStatus, CarDetails carDetails, CarAdditionalInfo carAdditionalInfo) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.price = price;
		this.location = location;
		this.yrOfManufacture = yrOfManufacture;
		this.soldStatus = "Pending";
		this.carDetails = carDetails;
		this.carAdditionalInfo = carAdditionalInfo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getYrOfManufacture() {
		return yrOfManufacture;
	}

	public void setYrOfManufacture(String yrOfManufacture) {
		this.yrOfManufacture = yrOfManufacture;
	}

	public String getSoldStatus() {
		return soldStatus;
	}

	public void setSoldStatus(String soldStatus) {
		this.soldStatus = soldStatus;
	}

	public CarDetails getCarDetails() {
		return carDetails;
	}

	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}

	public CarAdditionalInfo getCarAdditionalInfo() {
		return carAdditionalInfo;
	}

	public void setCarAdditionalInfo(CarAdditionalInfo carAdditionalInfo) {
		this.carAdditionalInfo = carAdditionalInfo;
	}

}
