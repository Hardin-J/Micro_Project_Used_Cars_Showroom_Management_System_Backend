package com.micro.used_car_showroom_management_system.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_sales_tbl")
public class CarSales {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Cars_sales_id")
	private long id;
	
	@ManyToOne
	@JoinColumn
	private Cars cars;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	@Column
	private LocalDate date = LocalDate.now();
	
	@Column(name = "Consolidated_price")
	private String price;
	
	@Column(name = "Approval_Status")
	private String approvalStatus = "Pending";

	public CarSales() {
		super();
	}

	public CarSales(long id, Cars cars, Customer customer, LocalDate date, String price, String approvalStatus) {
		super();
		this.id = id;
		this.cars = cars;
		this.customer = customer;
		this.date = date;
		this.price = price;
		this.approvalStatus = approvalStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cars getCars() {
		return cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
}
