package com.testBank.ABC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.testBank.ABC.models.Account;
import com.testBank.ABC.models.Transaction;
import com.testBank.ABC.services.AccountService;
import com.testBank.ABC.services.PdfExpoterService;
import com.testBank.ABC.services.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/createTransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		
		transactionService.createTransaction(transaction);
		return transaction;
		
	}
	@GetMapping("/alltransaction")
	public List<Transaction> getAllTransaction(){
		
		return transactionService.getAllTransaction();
	}
	
	@GetMapping("/transaction/{transactionId}")
	public Transaction findById(@PathVariable int transactionId) {
		return transactionService.getTransactionById(transactionId);
	}
	
	@DeleteMapping("/transactiondelete/{transactionId}")
	public String deleteById(@PathVariable int transactionId) {
		
		transactionService.deleteTransactionById(transactionId);
		return "Success Transaction Delete";
	}

	@PostMapping("/getalltransactions")
	public List<Transaction>getAllTransation(){
		return transactionService.getAllTransaction();
	}
	
	@PostMapping("/deposite")
	public void depositeMoney(@RequestBody Transaction transaction) {
		int accountID =transaction.getAccountNumber();
		System.out.println("full transaction record: "+transaction.toString());
		//System.out.println("id at controller: " + transaction.getAccNumber());
		float amount=transaction.getAmount();
		//System.out.println("before fetching account");
		Account depositeAccountID=accountService.findAccountbyID(accountID);
		System.out.println("reached this point");
		float newBalance=(accountService.findAccountbyID(accountID).getAccountBalance() + (float)amount);
		
		
		
		accountService.incrementValue(depositeAccountID, newBalance);
		transactionService.createTransaction(transaction);
		
	}
	
	
	@PostMapping("/withdraw")
	public void withdrawMoney(@RequestBody Transaction transaction) {
		
		int accountID = transaction.getAccountNumber();
//		System.out.println(transaction.toString());
//		System.out.println("id at controller: " + transaction.getAccNumber());
		float amount = transaction.getAmount();
//		System.out.println("before fetching account");
		Account depositeAccountID = accountService.findAccountbyID(accountID);
//		System.out.println("reached this point");
		float newBalace = (accountService.findAccountbyID(accountID).getAccountBalance() - (float) amount);
		
		accountService.incrementValue(depositeAccountID,newBalace);
		transactionService.createTransaction(transaction);
		
	}
	
	@PostMapping("/hellotransaction")
	public String transaction(@RequestBody Transaction transaction) {
		
		int accountID = transaction.getAccountNumber();
		int destinationAccID = transaction.getDestinationAccID();
		System.out.println(transaction.toString());
		//sSystem.out.println("id at controller: " + transaction.getAccNumber());
		float amount = transaction.getAmount();
		System.out.println("before fetching account");
		Account sourceaAccount = accountService.findAccountbyID(accountID);
		System.out.println("test");
		Account destinationAcc = accountService.findAccountbyID(destinationAccID);
		System.out.println("reached this point");
		
		
		
		float newSourcaebalace = (accountService.findAccountbyID(accountID).getAccountBalance() - (float) amount);
		float newDestinationbalace = (accountService.findAccountbyID(destinationAccID).getAccountBalance() + (float) amount);
		
		accountService.incremetValue(sourceaAccount, newSourcaebalace);
	    accountService.incrementValue(destinationAcc, newDestinationbalace);
		transactionService.createTransaction(transaction);
		return "Succesfully ";
		
	}
	
	@GetMapping("/exporttransaction/{ID}")
	public void createPdf(HttpServletResponse response,@PathVariable int ID) throws DocumentException, IOException{
		Account acc=accountService.getAccountByID(ID);
		response.setContentType("application/pdf");
		PdfExpoterService pdfService =new PdfExpoterService(accountService,acc);
		pdfService.createPdf(response);
	}
	
	

}
