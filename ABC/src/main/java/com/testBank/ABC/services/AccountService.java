package com.testBank.ABC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testBank.ABC.models.Account;
import com.testBank.ABC.respositories.AccountRespository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRespository accountRespository;
	
	public void createAccount(Account account) {
		accountRespository.save(account);
		
	}
	
	public List<Account> getAllAccount(){
		return accountRespository.findAll();
		
	}
	
	public Account findAccountbyID(int ID) {
		System.out.println("account ID: " + ID);
		return accountRespository.findById(ID).get();
	}
	
	public Account getAccountByID(int ID) {
		return accountRespository.findById(ID).get();
	}

    
	public void deleteAccountById(int ID) {
	     accountRespository.deleteById(ID);
	}
	
	public void incrementValue(Account account, Float newbalance) {
		account.setAccountBalance(newbalance);
		accountRespository.save(account);
	}
	
	public void incremetValue(Account account, float newbalance) {
		account.setAccountBalance(newbalance);
		accountRespository.save(account);
		
	}

}
