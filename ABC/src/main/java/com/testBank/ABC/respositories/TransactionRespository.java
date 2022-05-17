package com.testBank.ABC.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testBank.ABC.models.Transaction;

public interface TransactionRespository extends JpaRepository<Transaction,Integer>{
	
//	Optional<Transaction>findByTransactionId(int transactionId);
//	Optional<Transaction>deleteByTransactionId(int transactionId);
	

}
