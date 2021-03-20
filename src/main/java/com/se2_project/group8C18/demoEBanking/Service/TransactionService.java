package com.se2_project.group8C18.demoEBanking.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.ITransactionService;
import com.se2_project.group8C18.demoEBanking.Model.Account;
import com.se2_project.group8C18.demoEBanking.Model.Transaction;
import com.se2_project.group8C18.demoEBanking.Repository.AccountRepository;
import com.se2_project.group8C18.demoEBanking.Repository.BillRepository;
import com.se2_project.group8C18.demoEBanking.Repository.GiftRepository;
import com.se2_project.group8C18.demoEBanking.Repository.PaymentMethodRepository;
import com.se2_project.group8C18.demoEBanking.Repository.TransactionRepository;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	PaymentMethodRepository paymentMethodRepository;

	@Autowired
	BillRepository billRepository;

	@Autowired
	GiftRepository giftRepository;

	@Autowired
	AccountService accountService;
	
	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Override
	public Transaction getTransactionById(int transactionId) {
		if (transactionRepository.existsById(transactionId))
			return transactionRepository.findById(transactionId).get();
		return null;
	}

	@Override
	public List<Transaction> getAllTransactions() {

		return transactionRepository.findAll();
	}

	@Override
	public String addTransaction(String transaction) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Transaction tran = gson.fromJson(transaction, Transaction.class);

		if (accountRepository.existsById(tran.getAccount().getAccountId())) {
			if (paymentMethodRepository.existsById(tran.getPaymentMethod().getPaymentMethodId())) {
				if (!transactionRepository.existsById(tran.getTransactionId())) {
					if (checkValidate.getOk(tran)) {
					
						transactionRepository.save(tran);
						return errorType.getSuccesful();
					}
					return "Transaction " + errorType.isValidated(tran.getTransactionId());
				}
				return editTransaction(transaction);
			}
			return "paymentMethod " + errorType.isNotExisted(tran.getPaymentMethod().getPaymentMethodId());
		}
		return "Account" + errorType.isNotExisted(tran.getAccount().getAccountId());

	}

	@Override
	public String deleteTransactionById(int transactionId) {

		if (transactionRepository.existsById(transactionId)) {
			billRepository.deleteById(transactionId);
			giftRepository.deleteById(transactionId);
			transactionRepository.deleteById(transactionId);
			return errorType.getSuccesful();
		}
		return "Transaction " + errorType.isNotExisted(transactionId + "");
	}

	@Override
	public String editTransaction(String transaction) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Transaction tran = gson.fromJson(transaction, Transaction.class);

		if (transactionRepository.existsById(tran.getTransactionId())) {
			if (checkValidate.getOk(tran)) {
				Transaction fixTran = getTransactionById(tran.getTransactionId());

				transactionRepository.save(fixTran);
				return errorType.getSuccesful();
			}
			return "Transaction " + errorType.isValidated(tran.getTransactionId());
		}

		return "Transaction " + errorType.isNotExisted(tran.getTransactionId());
	}

	@Override
	public List<Transaction> getTransactionsByAccount(int accountId) {
		Account acc = accountService.findById(accountId);
		List<Transaction> trans = new ArrayList<Transaction>();
		
		if(acc != null)
		{
			acc.getTransactions().forEach(x -> trans.add(x));
		}
		return trans;
	}
	
	
	
}
