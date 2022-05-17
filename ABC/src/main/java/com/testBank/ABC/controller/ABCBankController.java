package com.testBank.ABC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testBank.ABC.models.User;




@RestController
public class ABCBankController {
	@GetMapping("/hello")
	public String hello() {
		return "Helllo World";
	}
	
	@GetMapping("/bankUser")
	public User bankUser() {
		User u =new User();
		u.setUserID(1);
		u.setFirstName("Dhananjali");
		u.setLastName("Herath");
		u.setAddress("Malpana,Kengalle");
		u.setUserEmail("dhananjali@gmail");
		u.setPassword("99999");
		
		return u;

		
		
	}
	

}
