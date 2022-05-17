package com.testBank.ABC.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testBank.ABC.models.Account;

public interface AccountRespository extends JpaRepository<Account,Integer>{
//	Optional<Account>findByAccountID(int accountID);
	
//	Optional<Account>deleteByAccountID(int accountID);

}
