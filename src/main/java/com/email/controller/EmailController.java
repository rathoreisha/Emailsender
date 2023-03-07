package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.email.Email;
import com.email.email.Gmailsender;



@RestController
public class EmailController {
	
	@Autowired
	private Gmailsender gmailsender;
	
	@PostMapping("/sendemail")
	public String sendEmail(@RequestBody Email email)
	{
		boolean sendEmail = gmailsender.sendEmail(email.getTo(), email.getFrom(), email.getSubject(),email.getText(), email.getContent());
		
		if(sendEmail)
		{
			return "email successfully sent";
		}
		else {
			return "email not send successfully";
		}
		
		
	}

}
