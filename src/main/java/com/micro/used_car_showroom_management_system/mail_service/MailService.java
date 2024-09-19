package com.micro.used_car_showroom_management_system.mail_service;

import com.micro.used_car_showroom_management_system.model.Cars;

import jakarta.mail.MessagingException;

public interface MailService {
	public String sendRegistrationConfirmation(String toMail, String username) throws MessagingException;

	public String sendTestDriveBookingAppointment(String toMail, String username, String slotTime, Cars car)
			throws MessagingException;

	public String sendTestDriveBookingNotificationToAdmin(String username, String slotTime, Cars car)
			throws MessagingException;

	public void sendOtp(String toMail, String otp) throws MessagingException;

	public String genOtp();

	public String sendTestDriveCancellationNotification(String toMail, String username, Cars car, String testDriveDate,
			String slot, String cancelReason) throws MessagingException;

	public String sendTestDriveCancellationToAdmin(String username, Cars car, String testDriveDate, String slot,
			String cancelReason) throws MessagingException;

	public String sendPurchaseBookingConfirmation(String toMail, String username, Cars car, String quotedPrice)
			throws MessagingException;

	public String sendPurchaseBookingNotificationToAdmin(String username, Cars car, String quotedPrice)
			throws MessagingException;

	public String sendPurchaseOfferAcceptedNotification(String toMail, String username, Cars car, String quotedPrice)
			throws MessagingException;

	public String sendPurchaseOfferRejectedNotification(String toMail, String username, Cars car, String quotedPrice)
			throws MessagingException;

}
