package com.testBank.ABC.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testBank.ABC.models.User;

public interface UserRepoEmail extends JpaRepository<User, String> {
	
	Optional<User> findByUserEmail(String Email);
	

}
