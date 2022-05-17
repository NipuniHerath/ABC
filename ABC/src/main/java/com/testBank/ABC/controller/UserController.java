package com.testBank.ABC.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testBank.ABC.models.RequestWrapper;
import com.testBank.ABC.models.User;
import com.testBank.ABC.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user)
	{
		userService.createUser(user);
		return user;
		
	}
	@GetMapping("/users")
	public List<User>getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	@GetMapping("/users/{userID}")
	public User findById(@PathVariable int userID) {
		return userService.getUserbyID(userID);
	}
	@DeleteMapping("/users/{userID}")
	public String Delete(@PathVariable int userID) {
		 return userService.deleteUserByID(userID);
		 
		
	}
	
	@CrossOrigin
	@GetMapping("/userall")
	public ResponseEntity list() {
		
		return ResponseEntity.status(HttpStatus.OK).body(new RequestWrapper(userService.getAllUsers(),"good","done"));
	}
	
	
	
	
}
