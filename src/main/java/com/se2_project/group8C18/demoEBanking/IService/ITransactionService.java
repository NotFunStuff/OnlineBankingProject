package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se2_project.group8C18.demoEBanking.Model.Transaction;
@Service
public interface ITransactionService {
	public Transaction getTransactionById(int transactionId);
	public List<Transaction> getAllTransactions();
	public String addTransaction(String transaction);
	public String deleteTransactionById(int transactionId);
	public String editTransaction(String transaction);
	public List<Transaction> getTransactionsByAccount(int accountId);
}
