package com.testBank.ABC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testBank.ABC.models.Transaction;
import com.testBank.ABC.respositories.TransactionRespository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRespository transactionRespository;
    
	public void createTransaction(Transaction transaction) {
		
		transactionRespository.save(transaction);
		
	}
	public List<Transaction> getAllTransaction(){
		
		return transactionRespository.findAll();
		
	}
	
	public Transaction getTransactionById(int tid) {
		
		return transactionRespository.findById(tid).get();
	}
	public void deleteTransactionById(int tid) {
		transactionRespository.deleteById(tid);
	}
	

}
