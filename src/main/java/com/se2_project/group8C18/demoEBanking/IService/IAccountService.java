package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.Account;


public interface IAccountService {
	
	
	public Account findById(int accountId) ;

	public List<Account> findAll();
	
	public String deleteAccountById(int accountId);
	
	public String addAccount(String account);
	
	public String editAccount(String account);
	
	public boolean isUserNameExisted(String accountName);
	
	public boolean isAccountExisted(String accountName, String password);
	
	
}
