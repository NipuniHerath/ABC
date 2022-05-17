
/*
 * A controller class that creates a rest controller to handle all authentication related requests
 * 
 */

package com.testBank.ABC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testBank.ABC.models.AuthenticationRequest;
import com.testBank.ABC.models.AuthenticationResponse;
import com.testBank.ABC.models.RequestWrapper;
import com.testBank.ABC.models.User;
import com.testBank.ABC.services.AuthUserDetailsService;
import com.testBank.ABC.services.UserService;
import com.testBank.ABC.utils.JwtUtil;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {
	
	//instantiate authenticationManager instance from spring security 
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	//instantiate AuthUserDetails service 
	@Autowired
	private AuthUserDetailsService userDetailsService;
	
	//instantiate User service 

	@Autowired
	private UserService userService;

	//single endpoint for authentication
	@CrossOrigin
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		Optional<User> correspondingUser = userService.findUserByEmail(userDetails.getUsername());
		
		


		RequestWrapper body = new RequestWrapper(new AuthenticationResponse(jwt,correspondingUser), "success", "fetched");
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(body);
			
	}

}
