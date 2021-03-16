package com.se2_project.group8C18.demoEBanking.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckProperty;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.IAccountService;
import com.se2_project.group8C18.demoEBanking.Model.Account;
import com.se2_project.group8C18.demoEBanking.Repository.AccountRepository;
import com.se2_project.group8C18.demoEBanking.Repository.BillRepository;
import com.se2_project.group8C18.demoEBanking.Repository.BusinessRepository;
import com.se2_project.group8C18.demoEBanking.Repository.GiftRepository;
import com.se2_project.group8C18.demoEBanking.Repository.NormalRepository;
import com.se2_project.group8C18.demoEBanking.Repository.PaymentMethodRepository;
import com.se2_project.group8C18.demoEBanking.Repository.ServiceRepository;
import com.se2_project.group8C18.demoEBanking.Repository.SysAdminRepository;
import com.se2_project.group8C18.demoEBanking.Repository.TransactionRepository;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	PaymentMethodRepository paymentMethodRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	GiftRepository giftRepository;
	
	@Autowired
	BusinessRepository businessRepository;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Autowired 
	BillRepository billRepository;
	
	@Autowired
	NormalRepository normalRepository;
	
	@Autowired
	SysAdminRepository sysAdminRepository;
	
	@Autowired
	PaymentMethodService paymentMethodService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	NormalService normalService;
	
	@Autowired
	ErrorType errorType;
	
	@Autowired
	CheckValidate checkValidate;
	
	@Autowired
	CheckProperty checkProperty;
	
	
	
	@Override
	public Account findById(int accountId) {
		if(accountRepository.existsById(accountId))
		{
			return accountRepository.findById(accountId).get();
		}
		return null;
	}

	@Override
	public List<Account> findAll() {
		
		return accountRepository.findAll();
	}

	
	/*
	 * @Effects: 
	 * 	Delete Account having account Id
	 * 		+ delete paymentMethod
	 * 		+ delete transactions (bills, gift)
	 */
	
	/// not finsish
	@Override
	public String deleteAccountById(int accountId) {
		if(accountRepository.existsById(accountId)) {
			Account acc = accountRepository.findById(accountId).get();
			acc.getPaymentMethods().forEach(x -> paymentMethodService.deletePaymentMethodById(x.getPaymentMethodId()));
			acc.getTransactions().forEach(x -> transactionService.deleteTransactionById(x.getTransactionId()));
				
			accountRepository.deleteById(accountId);
			
			return errorType.getSuccesful();
		}
		return "Account " + errorType.isNotExisted(accountId);
	}

	
	
	@Override
	public String addAccount(String account) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Account acc = gson.fromJson(account, Account.class);
		if(!accountRepository.existsById(acc.getAccountId())){
			if(checkValidate.getOk(acc))
			{
				acc.setTimeCreated(LocalDateTime.now());
				if(acc.getRole() == null || acc.getRole().equalsIgnoreCase("normal")) {
					acc.setRole("normal");
					normalService.addNormal(account);
				}
				if(acc.getRole().equalsIgnoreCase("business")) {
					businessService.addBusiness(account);
					
				}
				
				
				return errorType.getSuccesful();
			}
			
			return errorType.isValidated(acc.getName());
		}
		return editAccount(account);
	}

	
	
	
	@Override
	public String editAccount(String account) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Account acc = gson.fromJson(account, Account.class);
		
		if(accountRepository.existsById(acc.getAccountId())){
			if(checkValidate.getOk(acc))
			{	
				Account fixAccount = findById(acc.getAccountId());
				if(acc.getAvatar()!= null) fixAccount.setAvatar(acc.getAvatar());
				if(acc.getBio()!= null) fixAccount.setBio(acc.getBio());
				if(acc.getDateOfBirth()!= null) fixAccount.setDateOfBirth(acc.getDateOfBirth());
				if(acc.getName()!=null) fixAccount.setName(acc.getName());
				if(acc.getPhoneNumber()!=fixAccount.getPhoneNumber()) fixAccount.setPhoneNumber(acc.getPhoneNumber());
				accountRepository.save(fixAccount);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(acc.getName());
		}
		return errorType.isNotExisted(acc.getName());
	}

	@Override
	public Account getAccountByName(String accountName) {
	
		for(Account acc: accountRepository.findAll())
		{
			if(acc.getName().equalsIgnoreCase(accountName))
			{
				return acc;
			}
		}
		return null;
	}

	@Override
	public boolean checkPhoneNumber(String phoneNumber) {
		for(Account x: accountRepository.findAll()) {
			if(x.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				return true;
			}
		}
		return false;
	}
	
	
	
////	@Override
////	public boolean isUserNameExisted(String accountName) {
////		return accountRepository.getAccountByAccountName(accountName) != null;
////	}
//
//	@Override
//	public boolean isAccountExisted(String accountName, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isUserNameExisted(String accountName) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	

	
	
}
