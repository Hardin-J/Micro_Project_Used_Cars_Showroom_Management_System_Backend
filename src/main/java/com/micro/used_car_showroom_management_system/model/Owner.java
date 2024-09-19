package com.micro.used_car_showroom_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "Owner_tbl")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Owner_id")
	private long id;

	@Column(name = "Owner_name")
	private String name;

	@Column(name = "Owner_phone_number")
	private String phoneNumber;
	
	@Column(name = "Ownership_status")
	private String ownershipStatus;

	@Column(name = "Owner_address")
	private String address;

	@Lob
	@Column(length = 10485760)
	private byte[] rc;

	public Owner() {
		super();
	}

	public Owner(long id, String name, String phoneNumber, String ownershipStatus, String address, byte[] rc) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.ownershipStatus = ownershipStatus;
		this.address = address;
		this.rc = rc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOwnershipStatus() {
		return ownershipStatus;
	}

	public void setOwnershipStatus(String ownershipStatus) {
		this.ownershipStatus = ownershipStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getRc() {
		return rc;
	}

	public void setRc(byte[] rc) {
		this.rc = rc;
	}	
}
