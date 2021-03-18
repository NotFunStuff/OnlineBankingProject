package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se2_project.group8C18.demoEBanking.Model.Account;

@Service
public interface IAccountService {
	
	
	public Account findById(int accountId) ;

	public List<Account> findAll();
	
	public String deleteAccountById(int accountId);
	
	public String addAccount(String account);
	
	public String editAccount(String account);
	
	public Account getAccountByUserName(String userName);
	
	public boolean checkPhoneNumber(String phoneNumber);
	
	public Account getAccountByPhoneNumber(String phoneNumber);
}
