package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.Transaction;

public interface ITransactionService {
	public Transaction getTransactionById(int transactionId);
	public List<Transaction> getAllTransactions();
	public String addTransaction(String transaction);
	public String deleteTransactionById(int transactionId);
	public String editTransaction(String transaction);
}
