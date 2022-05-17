package com.testBank.ABC.controller;

import java.util.List;
import java.util.NoSuchElementException;

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


import com.testBank.ABC.models.Account;
import com.testBank.ABC.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody Account account) {
		System.out.println("accountDetail"+account.toString());
		accountService.createAccount(account);
		return account;
		
	}
	
	@GetMapping("/account")
	public List<Account>getAllAccount(){
		return accountService.getAllAccount();
		
	}
	@GetMapping("/account/{accountID}")
	public Account findByID(@PathVariable int accountID) {
		return accountService.getAccountByID(accountID);
		
	}
	
	@DeleteMapping("/accountdelete/{accountID}")
	public String deleteByID(@PathVariable int accountID) {
		
		accountService.deleteAccountById(accountID);
		return "Success Account Delete";
	}
	
//	@CrossOrigin
//	@GetMapping("/allaccount/{accountID}")
//	public ResponseEntity<List<Account>> get(@PathVariable int accountID){
//		try {
//			Account account= accountService.getAccountByID(accountID);
//          
//			
//			return ResponseEntity.status(HttpStatus.OK)
//					.body(accountService.getAllAccount());
//		}catch (NoSuchElementException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body(null);
//		}
//	}
	
	
	

}
