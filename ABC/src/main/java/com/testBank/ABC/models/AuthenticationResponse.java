/*
 * A model for the data to be sent back after authentication
 */


package com.testBank.ABC.models;

import java.io.Serializable;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public class AuthenticationResponse implements Serializable {

    private String jwt;
    private Optional<User> user;

 

    public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}




	public AuthenticationResponse(String jwt, Optional<User> user) {
		super();
		this.jwt = jwt;
		this.user = user;
	}




	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


	public Optional<User> getUser() {
		return user;
	}


	public void setUser(Optional<User> user) {
		this.user = user;
	}


	public String getJwt() {
        return jwt;
    }
}
