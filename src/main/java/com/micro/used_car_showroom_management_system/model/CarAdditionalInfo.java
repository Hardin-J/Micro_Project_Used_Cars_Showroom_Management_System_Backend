package com.micro.used_car_showroom_management_system.model;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_Additional_info_tbl")
public class CarAdditionalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Car_additional_detail_id")
	private long id;

	@Column(name = "Insurance_status")
	private String insuranceStatus;

	@Column(name = "Insurance_expiry")
	private String insuranceExpiresDate;

	@OneToOne
	private Owner owner;

	@OneToOne
	private CarImage carImage;

	public CarAdditionalInfo() {
		super();
	}

	public CarAdditionalInfo(long id, String insuranceStatus, String insuranceExpiresDate, Owner owner,
			CarImage carImage) {
		super();
		this.id = id;
		this.insuranceStatus = insuranceStatus;
		this.insuranceExpiresDate = insuranceExpiresDate;
		this.owner = owner;
		this.carImage = carImage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public String getInsuranceExpiresDate() {
		return insuranceExpiresDate;
	}

	public void setInsuranceExpiresDate(String insuranceExpiresDate) {
		this.insuranceExpiresDate = insuranceExpiresDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public CarImage getCarImage() {
		return carImage;
	}

	public void setCarImage(CarImage carImage) {
		this.carImage = carImage;
	}
}