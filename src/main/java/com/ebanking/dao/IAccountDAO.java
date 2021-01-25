package com.ebanking.dao;

import java.util.List;

import com.ebanking.model.Account;

public interface IAccountDAO {
	List<Account> findAll();
	Account findById(int accountId);
}
