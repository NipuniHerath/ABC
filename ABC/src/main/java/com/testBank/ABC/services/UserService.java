package com.testBank.ABC.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testBank.ABC.models.User;
import com.testBank.ABC.respositories.UserRepoEmail;
import com.testBank.ABC.respositories.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository userRespo;
	@Autowired
	private UserRepoEmail userRepository;
	
	
	public void createUser(User user) {
		userRespo.save(user);
		
		
	}
	
	public List<User>getAllUsers() {
		return userRespo.findAll();
		
		
	}
	
	public User getUserbyID(int ID) {
		return userRespo.findById(ID).get();
		
		
	}
	
	
	public String deleteUserByID(int ID) {
		 userRespo.deleteById(ID);
		return "Successful Delete";
	}
	
	public Optional<User> findUserByEmail(String email){
		return userRepository.findByUserEmail(email);
	}

}


