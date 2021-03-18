package com.se2_project.group8C18.demoEBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Model.Transaction;
import com.se2_project.group8C18.demoEBanking.Service.TransactionService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping(value = "/transaction/addTransaction")
	public String addTransaction(@RequestBody String transaction)
	{
		return transactionService.addTransaction(transaction);
	}
	
	@DeleteMapping(value = "/transaction/deleteTransactionById")
	public String deleteTransactionById(@RequestParam int transactionId)
	{
		return transactionService.deleteTransactionById(transactionId);
	}
	
	@GetMapping(value = "/transaction/getTransactionById")
	public Transaction getTransactionById(@RequestParam int transactionId)
	{
		return transactionService.getTransactionById(transactionId);
	}
	
	@GetMapping(value = "/transaction/getAllTransactions")
	public List<Transaction> getAllTransactions()
	{
		return transactionService.getAllTransactions();
	}
	
	
}
