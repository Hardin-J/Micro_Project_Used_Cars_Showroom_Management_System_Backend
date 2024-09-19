package com.micro.used_car_showroom_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_image_tbl")
public class CarImage {

	@Id
	@Column(name = "Car_image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(length = 10485760)
	private byte[] frontImage;
	@Lob
	@Column(length = 10485760)
	private byte[] backImage;
	@Lob
	@Column(length = 10485760)
	private byte[] leftSideImage;
	@Lob
	@Column(length = 10485760)
	private byte[] rightSideImage;
	@Lob
	@Column(length = 10485760)
	private byte[] interiorImage;

	public CarImage() {
		super();
	}

	public CarImage(long id, byte[] frontImage, byte[] backImage, byte[] leftSideImage, byte[] rightSideImage,
			byte[] interiorImage) {
		super();
		this.id = id;
		this.frontImage = frontImage;
		this.backImage = backImage;
		this.leftSideImage = leftSideImage;
		this.rightSideImage = rightSideImage;
		this.interiorImage = interiorImage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getFrontImage() {
		return frontImage;
	}

	public void setFrontImage(byte[] frontImage) {
		this.frontImage = frontImage;
	}

	public byte[] getBackImage() {
		return backImage;
	}

	public void setBackImage(byte[] backImage) {
		this.backImage = backImage;
	}

	public byte[] getLeftSideImage() {
		return leftSideImage;
	}

	public void setLeftSideImage(byte[] leftSideImage) {
		this.leftSideImage = leftSideImage;
	}

	public byte[] getRightSideImage() {
		return rightSideImage;
	}

	public void setRightSideImage(byte[] rightSideImage) {
		this.rightSideImage = rightSideImage;
	}

	public byte[] getInteriorImage() {
		return interiorImage;
	}

	public void setInteriorImage(byte[] interiorImage) {
		this.interiorImage = interiorImage;
	}
}
