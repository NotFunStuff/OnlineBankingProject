package com.ebanking.service;

import java.util.List;

import com.ebanking.model.Account;

public interface IAccountService {
	List<Account> findAll();
	Account findById(int accountId);
}
