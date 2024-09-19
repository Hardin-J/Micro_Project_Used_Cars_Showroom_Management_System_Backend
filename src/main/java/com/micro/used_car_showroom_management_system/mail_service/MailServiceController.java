package com.micro.used_car_showroom_management_system.mail_service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/mailServices")
public class MailServiceController {
	
	MailService service;
	String cntOtp = "";
	
	public MailServiceController(MailService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/verifyOtp/{otp}")
	public String doVerifyOtp(@PathVariable("otp") String otp) {
		String msg = "";
		try {
			if(cntOtp.equals(otp)) {
				msg = "Success";
			} else {
				msg = "Failed";				
			}			
		} catch (Exception e) {
			msg = e.toString();							
		}
		return msg;
	}
	
	
	@GetMapping("/{to}")
	public String doSendOtpToUser(@PathVariable("to") String to) {
		String msg = "";
		String otp = service.genOtp();
		try {
			service.sendOtp(to, otp);
			msg = otp;
			cntOtp = otp;
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}
}
