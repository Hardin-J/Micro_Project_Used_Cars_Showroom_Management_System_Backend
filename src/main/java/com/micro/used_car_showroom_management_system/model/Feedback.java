package com.micro.used_car_showroom_management_system.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Feedback_tbl")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Feedback_id")
	private long id;

	@Column
	private String review;

	@Column
	private int ratings;

	@ManyToOne
	@JoinColumn
	private Cars cars;

	@ManyToOne
	@JoinColumn
	private Customer customer;

	@Column
	private LocalTime time = LocalTime.now();

	@Column
	private LocalDate date = LocalDate.now();

	public Feedback() {
		super();
	}

	public Feedback(long id, String review, int ratings, Cars cars, Customer customer, LocalTime time, LocalDate date) {
		super();
		this.id = id;
		this.review = review;
		this.ratings = ratings;
		this.cars = cars;
		this.customer = customer;
		this.time = time;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
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

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
