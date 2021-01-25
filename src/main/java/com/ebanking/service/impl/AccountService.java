package com.ebanking.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.ebanking.dao.IAccountDAO;
import com.ebanking.model.Account;
import com.ebanking.service.IAccountService;

public class AccountService implements IAccountService {

	@Inject
	private IAccountDAO accountDAO;
	
//	public AccountService()
//	{
//		accountDAO = new AccountDAO();
//	}
	
	
	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public Account findById(int accountId) {
		return accountDAO.findById(accountId);
	}
	
	

}
