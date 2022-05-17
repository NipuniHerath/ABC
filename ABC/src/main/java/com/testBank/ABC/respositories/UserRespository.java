package com.testBank.ABC.respositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testBank.ABC.models.User;

public interface UserRespository extends JpaRepository <User, Integer>{
//	Optional<User>findByuserID( int userID);
	
	

}
