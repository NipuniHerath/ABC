package com.testBank.ABC.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String firstName;
	private String lastName;
	private String address;
	private String userEmail;
	private String password;
	
	@OneToMany(mappedBy="owner")
	@JsonIgnoreProperties("Owner")
	
	private List<Account> accont;
	
	
	public User(int userID, String firstName, String lastName, String address, String userEmail, String password,
			List<Account> accont) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.userEmail = userEmail;
		this.password = password;
		this.accont = accont;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Account> getAccont() {
		return accont;
	}
	public void setAccont(List<Account> accont) {
		this.accont = accont;
	}
	
	
	
	

}
