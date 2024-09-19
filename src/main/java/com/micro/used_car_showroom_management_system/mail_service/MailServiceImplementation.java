package com.micro.used_car_showroom_management_system.mail_service;

import org.springframework.stereotype.Service;

import com.micro.used_car_showroom_management_system.model.Cars;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class MailServiceImplementation implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	private static final SecureRandom RANDOM = new SecureRandom();

	private String adminMailId = "mrjeeva1011@gmail.com";

	@Override
	public String sendRegistrationConfirmation(String toMail, String username) throws MessagingException {
		String msg = "";
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String closingDiv = "</div>";

			helper.setTo(toMail);
			helper.setSubject("Registration Successful – Welcome to Revved Autos!");

			String htmlContent = "<html>"
					+ "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
					+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
					+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
					+ "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #333;'>Welcome to Revved Autos!</h1>"
					+ "<p style='font-size: 18px; color: #555;'>Your trusted partner in used car management.</p>"
					+ closingDiv + "<div style='padding: 30px 20px; text-align: center;'>"
					+ "<p style='font-size: 16px; margin: 0 0 10px;'>Dear " + username + ",</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Thank you for joining Revved Autos! We're excited to have you on board. Your account has been successfully created and is ready to use.</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>To get started, <a href='https://www.revvedautos.com/login' style='color: #FF5722; text-decoration: none; font-weight: 600;'>login here</a> to access your account, explore our features, and manage your vehicles efficiently.</p>"
					+ "<p style='font-size: 14px; margin: 0;'>If you have any questions or need assistance, our support team is here to help. Feel free to contact us at <a href='mailto:support@revvedautos.com' style='color: #FF5722;'>support@revvedautos.com</a>.</p>"
					+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
					+ "<p style='margin: 0;'>Welcome aboard,<br>Team Revved Autos</p>" + closingDiv
					+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
					+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
					+ closingDiv + closingDiv + "</body>" + "</html>";
			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			msg = "Mail Sent Successfully";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}

	@Override
	public String sendTestDriveBookingAppointment(String toMail, String username, String slotTime, Cars car)
			throws MessagingException {
		String msg = "";
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String closingDiv = "</div>";

			helper.setTo(toMail);
			helper.setSubject("Test Drive Booking Confirmation – Revved Autos");

			String htmlContent = "<html>"
					+ "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
					+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
					+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
					+ "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #333;'>Revved Autos</h1>"
					+ "<p style='font-size: 18px; color: #555;'>Your Test Drive Appointment Confirmation</p>"
					+ closingDiv + "<div style='padding: 30px 20px; text-align: center;'>"
					+ "<p style='font-size: 16px; margin: 0 0 10px;'>Dear " + username + ",</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Thank you for booking a test drive with Revved Autos! We have successfully scheduled your test drive appointment.</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details of your appointment:</p>"
					+ "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
					+ car.getMake() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
					+ car.getModel() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
					+ car.getPrice() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
					+ car.getLocation() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
					+ car.getYrOfManufacture() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Appointment Slot:</td><td style='padding: 8px;'>"
					+ slotTime + "</td></tr>" + "</table>"
					+ "<p style='font-size: 14px; margin: 20px 0;'>If you need to reschedule or have any questions, please contact our support team at <a href='mailto:support@revvedautos.com' style='color: #FF5722;'>support@revvedautos.com</a>.</p>"
					+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
					+ "<p style='margin: 0;'>Looking forward to seeing you,<br>Team Revved Autos</p>" + closingDiv
					+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
					+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
					+ closingDiv + closingDiv + "</body>" + "</html>";
			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			msg = "Mail Sent Successfully";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}

	@Override
	public String sendTestDriveBookingNotificationToAdmin(String username, String slotTime, Cars car)
			throws MessagingException {
		String msg = "";
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String closingDiv = "</div>";

			helper.setTo(adminMailId);
			helper.setSubject("New Test Drive Booking – Action Required");

			String htmlContent = "<html>"
					+ "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
					+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
					+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
					+ "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #333;'>Revved Autos</h1>"
					+ "<p style='font-size: 18px; color: #555;'>New Test Drive Booking Notification</p>" + closingDiv
					+ "<div style='padding: 30px 20px; text-align: center;'>"
					+ "<p style='font-size: 16px; margin: 0 0 10px;'>Dear Admin,</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>A new test drive appointment has been booked. Please prepare the car for the test drive at the specified time.</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details:</p>"
					+ "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Customer Name:</td><td style='padding: 8px;'>"
					+ username + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
					+ car.getMake() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
					+ car.getModel() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
					+ car.getPrice() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
					+ car.getLocation() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
					+ car.getYrOfManufacture() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Appointment Slot:</td><td style='padding: 8px;'>"
					+ slotTime + "</td></tr>" + "</table>"
					+ "<p style='font-size: 14px; margin: 20px 0;'>Please make sure the car is prepared and ready for the customer at the specified time. If you need to reschedule or require additional information, please contact the customer or our support team.</p>"
					+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
					+ "<p style='margin: 0;'>Thank you,<br>Team Revved Autos</p>" + closingDiv
					+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
					+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
					+ closingDiv + closingDiv + "</body>" + "</html>";

			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			msg = "Mail Sent Successfully";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}

	@Override
	public void sendOtp(String toMail, String otp) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		String closingDiv = "</div>";

		helper.setTo(toMail);
		helper.setSubject("Your OTP Code");

		String htmlContent = "<html>"
				+ "<body style='font-family: Arial, sans-serif; background-color: #f4f4f7; padding: 30px 0; color: #333;'>"
				+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 10px; overflow: hidden; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);'>"
				+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #f3f4f6; background-color: #fff;'>"
				+ "<h1 style='margin: 0; font-size: 30px; font-weight: 700; color: #FF5722;'>Revved Autos</h1>"
				+ closingDiv + "<div style='padding: 30px 20px; text-align: center;'>"
				+ "<p style='font-size: 16px; margin: 0 0 8px;'>Dear User,</p>"
				+ "<p style='font-size: 16px; margin: 0 0 30px;'>Your One-Time Password (OTP) for verifying your account is:</p>"
				+ "<p style='font-size: 24px; font-weight: 700; margin: 0 0 30px; color: #FF5722;'>" + otp + "</p>"
				+ "<p style='font-size: 14px; margin: 0;'>If you did not request this code, please ignore this email.</p>"
				+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f9f9f9;'>"
				+ "<p style='margin: 0;'>Best regards,<br>Team Revved Autos</p>" + closingDiv
				+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #aaa;'>"
				+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
				+ closingDiv + closingDiv + "</body>" + "</html>";

		helper.setText(htmlContent, true);
		javaMailSender.send(message);
	}

	@Override
	public String genOtp() {
		int otp = RANDOM.nextInt(999999); // Generate a random number up to 999999
		return String.format("%06d", otp); // Format as a 6-digit number with leading zeros
	}

	public String sendTestDriveCancellationNotification(String toMail, String username, Cars car, String testDriveDate,
			String slot, String cancelReason) throws MessagingException {
		String msg = "";
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String closingDiv = "</div>";

			helper.setTo(toMail);
			helper.setSubject("Test Drive Booking Cancellation – Revved Autos");

			String htmlContent = "<html>"
					+ "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
					+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
					+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
					+ "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #FF5722;'>Revved Autos</h1>"
					+ "<p style='font-size: 18px; color: #555;'>Test Drive Cancellation Notification</p>" + closingDiv
					+ "<div style='padding: 30px 20px; text-align: center;'>"
					+ "<p style='font-size: 16px; margin: 0 0 10px;'>Dear " + username + ",</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>We regret to inform you that your test drive appointment scheduled for <strong>"
					+ testDriveDate + "</strong> at <strong>" + slot + "</strong> has been cancelled.</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details of your appointment:</p>"
					+ "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
					+ car.getMake() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
					+ car.getModel() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
					+ car.getPrice() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
					+ car.getLocation() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
					+ car.getYrOfManufacture() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Cancelled Appointment Slot:</td><td style='padding: 8px;'>"
					+ slot + "</td></tr>" + "</table>"
					+ "<p style='font-size: 16px; margin: 20px 0;'>Reason for Cancellation: <strong>" + cancelReason
					+ "</strong></p>"
					+ "<p style='font-size: 16px; margin: 20px 0;'>If you have any questions or wish to reschedule, please contact our support team at <a href='mailto:support@revvedautos.com' style='color: #FF5722;'>support@revvedautos.com</a>.</p>"
					+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
					+ "<p style='margin: 0;'>Thank you for your understanding,<br>Team Revved Autos</p>" + closingDiv
					+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
					+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
					+ closingDiv + closingDiv + "</body>" + "</html>";

			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			msg = "Mail Sent Successfully";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}

	@Override
	public String sendTestDriveCancellationToAdmin(String username, Cars car, String testDriveDate, String slot,
			String cancelReason) throws MessagingException {
		String msg = "";
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String closingDiv = "</div>";

			helper.setTo(adminMailId);
			helper.setSubject("Test Drive Booking Cancellation – Action Required – Revved Autos");

			String htmlContent = "<html>"
					+ "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
					+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
					+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
					+ "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #FF5722;'>Revved Autos</h1>"
					+ "<p style='font-size: 18px; color: #555;'>Test Drive Booking Cancellation – Action Required</p>"
					+ closingDiv + "<div style='padding: 30px 20px; text-align: center;'>"
					+ "<p style='font-size: 16px; margin: 0 0 10px;'>Dear Admin,</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>We want to inform you that a test drive appointment has been cancelled. Please find the details below and take necessary action to reassign or manage the slot.</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details of the cancelled appointment:</p>"
					+ "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Customer Name:</td><td style='padding: 8px;'>"
					+ username + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
					+ car.getMake() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
					+ car.getModel() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
					+ car.getPrice() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
					+ car.getLocation() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
					+ car.getYrOfManufacture() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Cancelled Appointment Date:</td><td style='padding: 8px;'>"
					+ testDriveDate + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Cancelled Appointment Slot:</td><td style='padding: 8px;'>"
					+ slot + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Reason for Cancellation:</td><td style='padding: 8px;'>"
					+ cancelReason + "</td></tr>" + "</table>"
					+ "<p style='font-size: 16px; margin: 20px 0;'>Please review the details and update the system accordingly to ensure the slot is available for other customers.</p>"
					+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
					+ "<p style='margin: 0;'>Thank you for your attention to this matter,<br>Team Revved Autos</p>"
					+ closingDiv
					+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
					+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
					+ closingDiv + closingDiv + "</body>" + "</html>";

			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			msg = "Mail Sent Successfully";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}

	@Override
	public String sendPurchaseBookingConfirmation(String toMail, String username, Cars car, String quotedPrice)
			throws MessagingException {
		String msg = "";
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String closingDiv = "</div>";

			helper.setTo(toMail);
			helper.setSubject("Purchase Booking Confirmation – Revved Autos");

			String htmlContent = "<html>"
					+ "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
					+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
					+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
					+ "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #333;'>Revved Autos</h1>"
					+ "<p style='font-size: 18px; color: #555;'>Your Purchase Booking Confirmation</p>" + closingDiv
					+ "<div style='padding: 30px 20px; text-align: center;'>"
					+ "<p style='font-size: 16px; margin: 0 0 10px;'>Dear " + username + ",</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Thank you for booking a purchase with Revved Autos! Your purchase booking has been successfully confirmed.</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details of your booking:</p>"
					+ "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
					+ car.getMake() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
					+ car.getModel() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
					+ car.getPrice() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Quoted Price:</td><td style='padding: 8px;'>"
					+ quotedPrice + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
					+ car.getLocation() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
					+ car.getYrOfManufacture() + "</td></tr>" + "</table>"
					+ "<p style='font-size: 14px; margin: 20px 0;'>If you need to make changes or have any questions, please contact our support team at <a href='mailto:support@revvedautos.com' style='color: #FF5722;'>support@revvedautos.com</a>.</p>"
					+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
					+ "<p style='margin: 0;'>Looking forward to completing your purchase,<br>Team Revved Autos</p>"
					+ closingDiv
					+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
					+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
					+ closingDiv + closingDiv + "</body>" + "</html>";

			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			msg = "Mail Sent Successfully";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}

	@Override
	public String sendPurchaseBookingNotificationToAdmin(String username, Cars car, String quotedPrice)
			throws MessagingException {
		String msg = "";
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			String closingDiv = "</div>";

			helper.setTo(adminMailId);
			helper.setSubject("New Purchase Booking – Action Required");

			String htmlContent = "<html>"
					+ "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
					+ "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
					+ "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
					+ "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #333;'>Revved Autos</h1>"
					+ "<p style='font-size: 18px; color: #555;'>New Purchase Booking Notification</p>" + closingDiv
					+ "<div style='padding: 30px 20px; text-align: center;'>"
					+ "<p style='font-size: 16px; margin: 0 0 10px;'>Dear Admin,</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>A new car purchase has been booked. Please review the booking and proceed with the necessary steps.</p>"
					+ "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details:</p>"
					+ "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Customer Name:</td><td style='padding: 8px;'>"
					+ username + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
					+ car.getMake() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
					+ car.getModel() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
					+ car.getPrice() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Quoted Price:</td><td style='padding: 8px;'>"
					+ quotedPrice + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
					+ car.getLocation() + "</td></tr>"
					+ "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
					+ car.getYrOfManufacture() + "</td></tr>" + "</table>"
					+ "<p style='font-size: 14px; margin: 20px 0;'>Please make sure the process is carried out smoothly. If you need any assistance, feel free to contact the customer or our support team.</p>"
					+ closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
					+ "<p style='margin: 0;'>Thank you,<br>Team Revved Autos</p>" + closingDiv
					+ "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
					+ "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
					+ closingDiv + closingDiv + "</body>" + "</html>";

			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			msg = "Mail Sent Successfully";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}
	
	@Override
	public String sendPurchaseOfferAcceptedNotification(String toMail, String username, Cars car, String quotedPrice) 
	        throws MessagingException {
	    String msg = "";
	    try {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        String closingDiv = "</div>";

	        helper.setTo(toMail);
	        helper.setSubject("Your Purchase Offer Has Been Accepted – Revved Autos");

	        String htmlContent = "<html>"
	                + "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
	                + "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
	                + "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
	                + "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #333;'>Revved Autos</h1>"
	                + "<p style='font-size: 18px; color: #555;'>Purchase Offer Accepted</p>" + closingDiv
	                + "<div style='padding: 30px 20px; text-align: center;'>"
	                + "<p style='font-size: 16px; margin: 0 0 10px;'>Dear " + username + ",</p>"
	                + "<p style='font-size: 16px; margin: 0 0 20px;'>Congratulations! Your purchase offer for the car has been accepted. Please visit our showroom to complete the purchase procedure.</p>"
	                + "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details of your offer:</p>"
	                + "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
	                + car.getMake() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
	                + car.getModel() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
	                + car.getPrice() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Quoted Price:</td><td style='padding: 8px;'>"
	                + quotedPrice + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
	                + car.getLocation() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
	                + car.getYrOfManufacture() + "</td></tr>" 
	                + "</table>"
	                + "<p style='font-size: 14px; margin: 20px 0;'>Please visit our showroom to complete the payment process. If you have any questions or need assistance, feel free to contact us.</p>"
	                + closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
	                + "<p style='margin: 0;'>Thank you,<br>Team Revved Autos</p>" + closingDiv
	                + "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
	                + "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
	                + closingDiv + closingDiv + "</body>" + "</html>";

	        helper.setText(htmlContent, true);
	        javaMailSender.send(message);
	        msg = "Mail Sent Successfully";
	    } catch (Exception e) {
	        msg = e.toString();
	    }
	    return msg;
	}
	
	@Override
	public String sendPurchaseOfferRejectedNotification(String toMail, String username, Cars car, String quotedPrice) 
	        throws MessagingException {
	    String msg = "";
	    try {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        String closingDiv = "</div>";

	        helper.setTo(toMail);
	        helper.setSubject("Your Purchase Offer Has Been Rejected – Revved Autos");

	        String htmlContent = "<html>"
	                + "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 30px 0; color: #333;'>"
	                + "<div style='max-width: 600px; width: 100%; margin: 0 auto; background: #fff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);'>"
	                + "<div style='padding: 40px 20px; text-align: center; border-bottom: 1px solid #e0e0e0; background-color: #fff;'>"
	                + "<h1 style='margin: 0; font-size: 32px; font-weight: 700; color: #333;'>Revved Autos</h1>"
	                + "<p style='font-size: 18px; color: #555;'>Purchase Offer Rejected</p>" + closingDiv
	                + "<div style='padding: 30px 20px; text-align: center;'>"
	                + "<p style='font-size: 16px; margin: 0 0 10px;'>Dear " + username + ",</p>"
	                + "<p style='font-size: 16px; margin: 0 0 20px;'>We regret to inform you that your purchase offer for the car has been rejected. Unfortunately, we are unable to proceed with your offer at this time.</p>"
	                + "<p style='font-size: 16px; margin: 0 0 20px;'>Here are the details of your offer:</p>"
	                + "<table style='width: 100%; margin: 0 auto; border-collapse: collapse;'>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Car Make:</td><td style='padding: 8px;'>"
	                + car.getMake() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Car Model:</td><td style='padding: 8px;'>"
	                + car.getModel() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Price:</td><td style='padding: 8px;'>"
	                + car.getPrice() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Quoted Price:</td><td style='padding: 8px;'>"
	                + quotedPrice + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Location:</td><td style='padding: 8px;'>"
	                + car.getLocation() + "</td></tr>"
	                + "<tr><td style='padding: 8px; font-weight: bold;'>Year of Manufacture:</td><td style='padding: 8px;'>"
	                + car.getYrOfManufacture() + "</td></tr>"
	                + "</table>"
	                + "<p style='font-size: 14px; margin: 20px 0;'>If you have any questions or need further clarification, please feel free to contact us.</p>"
	                + closingDiv + "<div style='padding: 20px; text-align: center; background-color: #f2f2f2;'>"
	                + "<p style='margin: 0;'>Thank you,<br>Team Revved Autos</p>" + closingDiv
	                + "<div style='max-width: 600px; width: 100%; margin: 8px auto 0; text-align: center; font-size: 12px; color: #888;'>"
	                + "<p style='margin: 0;'>Secured by <a href='https://www.revvedautos.com' style='color: #FF5722; text-decoration: none; font-weight: 600;' target='_blank'>Revved Autos</a></p>"
	                + closingDiv + closingDiv + "</body>" + "</html>";

	        helper.setText(htmlContent, true);
	        javaMailSender.send(message);
	        msg = "Mail Sent Successfully";
	    } catch (Exception e) {
	        msg = e.toString();
	    }
	    return msg;
	}



}
