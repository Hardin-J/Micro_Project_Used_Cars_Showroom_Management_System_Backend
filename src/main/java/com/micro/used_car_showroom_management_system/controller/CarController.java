package com.micro.used_car_showroom_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.micro.used_car_showroom_management_system.model.CarAdditionalInfo;
import com.micro.used_car_showroom_management_system.model.CarDetails;
import com.micro.used_car_showroom_management_system.model.CarImage;
import com.micro.used_car_showroom_management_system.model.Cars;
import com.micro.used_car_showroom_management_system.model.Owner;
import com.micro.used_car_showroom_management_system.repository.CarAdditionalInfoRepository;
import com.micro.used_car_showroom_management_system.repository.CarDetailsRepository;
import com.micro.used_car_showroom_management_system.repository.CarImageRepository;
import com.micro.used_car_showroom_management_system.repository.OwnerRepository;
import com.micro.used_car_showroom_management_system.service.CarsService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/cars")
public class CarController {

	CarsService service;
	CarDetailsRepository carDetailsRepository;
	OwnerRepository ownerRepository;
	CarAdditionalInfoRepository carAdditionalInfoRepository;
	CarImageRepository carImageRepository;

	public CarController(CarsService service, CarDetailsRepository carDetailsRepository,
			OwnerRepository ownerRepository, CarAdditionalInfoRepository carAdditionalInfoRepository,
			CarImageRepository carImageRepository) {
		super();
		this.service = service;
		this.carDetailsRepository = carDetailsRepository;
		this.ownerRepository = ownerRepository;
		this.carAdditionalInfoRepository = carAdditionalInfoRepository;
		this.carImageRepository = carImageRepository;
	}

	@PostMapping
	public Cars doAddNewCar(@RequestParam("make") String make, @RequestParam("model") String model,
			@RequestParam("price") String price, @RequestParam("location") String location,
			@RequestParam("yrOfManufacture") String yrOfManufacture,

			@RequestParam("bodyType") String bodyType, @RequestParam("kmsDriven") String kmsDriven,
			@RequestParam("fuelType") String fuelType, @RequestParam("color") String color,
			@RequestParam("transmission") String transmission, @RequestParam("regYear") String regYear,
			@RequestParam("seats") String seats, @RequestParam("engineDisplacement") String engineDisplacement,

			@RequestParam("insuranceStatus") String insuranceStatus,
			@RequestParam("insuranceExpiresDate") String insuranceExpiresDate,

			@RequestParam("ownerName") String ownerName, @RequestParam("ownerPhoneNumber") String ownerPhoneNumber,
			@RequestParam("ownershipStatus") String ownershipStatus, @RequestParam("ownerAddress") String ownerAddress,
			@RequestParam("rc") MultipartFile rc,

			@RequestParam("frontImage") MultipartFile frontImage, @RequestParam("backImage") MultipartFile backImage,
			@RequestParam("leftSideImage") MultipartFile leftSideImage,
			@RequestParam("rightSideImage") MultipartFile rightSideImage,
			@RequestParam("interiorImage") MultipartFile interiorImage) {
		try {
			Cars car = new Cars();
			car.setMake(make);
			car.setModel(model);
			car.setPrice(price);
			car.setLocation(location);
			car.setYrOfManufacture(yrOfManufacture);
//			car.setSoldStatus(soldStatus);

			CarDetails carDetails = new CarDetails();
			carDetails.setBodyType(bodyType);
			carDetails.setKmsDriven(kmsDriven);
			carDetails.setFuelType(fuelType);
			carDetails.setColor(color);
			carDetails.setTransmission(transmission);
			carDetails.setRegYear(regYear);
			carDetails.setSeats(seats);
			carDetails.setEngineDisplacement(engineDisplacement);
			carDetails = carDetailsRepository.save(carDetails);

			CarAdditionalInfo carAdditionalInfo = new CarAdditionalInfo();
			carAdditionalInfo.setInsuranceStatus(insuranceStatus);
			carAdditionalInfo.setInsuranceExpiresDate(insuranceExpiresDate);

			Owner owner = new Owner();
			owner.setName(ownerName);
			owner.setPhoneNumber(ownerPhoneNumber);
			owner.setOwnershipStatus(ownershipStatus);
			owner.setAddress(ownerAddress);
			owner.setRc(rc.getBytes()); // Convert file to byte array
			owner = ownerRepository.save(owner);

			CarImage carImage = new CarImage();
			carImage.setFrontImage(frontImage.getBytes()); // Convert file to byte array
			carImage.setBackImage(backImage.getBytes()); // Convert file to byte array
			carImage.setLeftSideImage(leftSideImage.getBytes()); // Convert file to byte array
			carImage.setRightSideImage(rightSideImage.getBytes()); // Convert file to byte array
			carImage.setInteriorImage(interiorImage.getBytes()); // Convert file to byte array
			carImage = carImageRepository.save(carImage);

			carAdditionalInfo.setOwner(owner);
			carAdditionalInfo.setCarImage(carImage);
			carAdditionalInfo = carAdditionalInfoRepository.save(carAdditionalInfo);

			car.setCarDetails(carDetails);
			car.setCarAdditionalInfo(carAdditionalInfo);

			service.addNewCars(car);
			return car;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/{id}")
	public Cars doUpdateCar(@PathVariable("id") long id, @RequestParam("make") String make,
			@RequestParam("model") String model, @RequestParam("price") String price,
			@RequestParam("location") String location, @RequestParam("yrOfManufacture") String yrOfManufacture,

			@RequestParam("bodyType") String bodyType, @RequestParam("kmsDriven") String kmsDriven,
			@RequestParam("fuelType") String fuelType, @RequestParam("color") String color,
			@RequestParam("transmission") String transmission, @RequestParam("regYear") String regYear,
			@RequestParam("seats") String seats, @RequestParam("engineDisplacement") String engineDisplacement,

			@RequestParam("insuranceStatus") String insuranceStatus,
			@RequestParam("insuranceExpiresDate") String insuranceExpiresDate,

			@RequestParam("ownerName") String ownerName, @RequestParam("ownerPhoneNumber") String ownerPhoneNumber,
			@RequestParam("ownershipStatus") String ownershipStatus, @RequestParam("ownerAddress") String ownerAddress,
			@RequestParam("rc") MultipartFile rc,

			@RequestParam("frontImage") MultipartFile frontImage, @RequestParam("backImage") MultipartFile backImage,
			@RequestParam("leftSideImage") MultipartFile leftSideImage,
			@RequestParam("rightSideImage") MultipartFile rightSideImage,
			@RequestParam("interiorImage") MultipartFile interiorImage) {
		try {
			Cars car = service.getSingleCar(id);
			car.setMake(make);
			car.setModel(model);
			car.setPrice(price);
			car.setLocation(location);
			car.setYrOfManufacture(yrOfManufacture);
//			car.setSoldStatus(soldStatus);

			CarDetails carDetails = car.getCarDetails();
			carDetails.setBodyType(bodyType);
			carDetails.setKmsDriven(kmsDriven);
			carDetails.setFuelType(fuelType);
			carDetails.setColor(color);
			carDetails.setTransmission(transmission);
			carDetails.setRegYear(regYear);
			carDetails.setSeats(seats);
			carDetails.setEngineDisplacement(engineDisplacement);
			carDetails = carDetailsRepository.save(carDetails);

			CarAdditionalInfo carAdditionalInfo = car.getCarAdditionalInfo();
			carAdditionalInfo.setInsuranceStatus(insuranceStatus);
			carAdditionalInfo.setInsuranceExpiresDate(insuranceExpiresDate);

			Owner owner = carAdditionalInfo.getOwner();
			owner.setName(ownerName);
			owner.setPhoneNumber(ownerPhoneNumber);
			owner.setOwnershipStatus(ownershipStatus);
			owner.setAddress(ownerAddress);
			owner.setRc(rc.getBytes()); // Convert file to byte array
			owner = ownerRepository.save(owner);

			CarImage carImage = carAdditionalInfo.getCarImage();
			carImage.setFrontImage(frontImage.getBytes()); // Convert file to byte array
			carImage.setBackImage(backImage.getBytes()); // Convert file to byte array
			carImage.setLeftSideImage(leftSideImage.getBytes()); // Convert file to byte array
			carImage.setRightSideImage(rightSideImage.getBytes()); // Convert file to byte array
			carImage.setInteriorImage(interiorImage.getBytes()); // Convert file to byte array
			carImage = carImageRepository.save(carImage);

			carAdditionalInfo.setOwner(owner);
			carAdditionalInfo.setCarImage(carImage);
			carAdditionalInfo = carAdditionalInfoRepository.save(carAdditionalInfo);

			car.setCarDetails(carDetails);
			car.setCarAdditionalInfo(carAdditionalInfo);

			service.addUpdateCar(car);
			return car;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Cars> doFetchAllCars() {
		return service.fetchAllCars();
	}

	@GetMapping("/car/{id}")
	public Cars fetchSingleCar(@PathVariable long id) {
		return service.getSingleCar(id);
	}

}
