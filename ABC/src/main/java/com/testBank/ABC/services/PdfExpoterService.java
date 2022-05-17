package com.testBank.ABC.services;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.testBank.ABC.models.Account;
import com.testBank.ABC.models.Transaction;
import com.testBank.ABC.models.User;

@Service
public class PdfExpoterService {
	
	private AccountService accountServiceW;
	private Account acc;
	

	
	public PdfExpoterService(AccountService accountServiceW, Account acc) {
		super();
		this.accountServiceW = accountServiceW;
		this.acc = acc;
	}



	public PdfExpoterService() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void createPdf(HttpServletResponse response) throws DocumentException, IOException{
		
		Date date =new Date();
		String stringDateFormat ="hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
		String formattedDate = dateFormat.format(date);
		System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
		
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		document.add(new Phrase("ABC BANK"));
		document.add(new Phrase("   ........................................."));
		document.add(new Paragraph("Date :"+formattedDate));
		document.add(new Phrase("Bank Transaction List"));
		document.add(new Paragraph("Owner IdentyNumber:"+acc.getOwner().getUserID()));
		document.add(new Paragraph("Ful Name:"+acc.getOwner().getFirstName()+" "+acc.getOwner().getLastName()));
		document.add(new Paragraph("Address:"+acc.getOwner().getAddress()));
		document.add(new Paragraph("Email:"+acc.getOwner().getAddress()));
		document.add(new Paragraph("Password:"+acc.getOwner().getPassword()));
		
		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(20);
	
		table.setWidthPercentage(90);
		
		PdfPCell cell =new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPhrase(new Phrase("Transaction ID"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Account Number"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Amount"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Date & Time"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Type"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Destination ID"));
        table.addCell(cell);
        
        
        
       
        
        for(Transaction transaction:acc.getTransactionP()) {
        
        	table.addCell(Integer.toString(transaction.getTransactionID()));
        	table.addCell(Integer.toString(transaction.getAccountNumber()));
        	table.addCell(Float.toString(transaction.getAmount()));
        	table.addCell(transaction.getDate_time().toString());
        	table.addCell(transaction.getType());
        	table.addCell(Integer.toString(transaction.getDestinationAccID()));
        	
        }
		document.add(table);
		   document.close();
		
	}
	
	
	
	

}
