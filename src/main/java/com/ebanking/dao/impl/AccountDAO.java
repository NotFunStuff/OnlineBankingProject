package com.ebanking.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebanking.dao.IAccountDAO;
import com.ebanking.model.Account;

public class AccountDAO extends NewDAO implements IAccountDAO{
	
	
	@Override
	public List<Account> findAll() {
		List<Account> accs = new ArrayList<Account>();
		String sql = "SELECT * FROM ebanking.account;";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null)
		{
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next())
				{
					Account account = new Account();
					account.setAccountId(resultSet.getInt("accountId"));
					account.setAccountName(resultSet.getString("accountName"));
					account.setCardId(resultSet.getInt("cardId"));
					account.setLocation(resultSet.getString("location"));
					accs.add(account);
				}
				return accs;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(connection != null)
					{
						connection.close();
					}
					if(statement != null)
					{
						statement.close();
					}
					if(resultSet != null)
					{
						resultSet.close();
					}
				}catch (SQLException e) {
					return null;
				}
				
			}
		}
		return null;
		
	}

	@Override
	public Account findById(int accountId) {
		Account account = new Account();
		String sql = "SELECT * FROM ebanking.account where accountId = ?;";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null)
		{
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, accountId);
				resultSet = statement.executeQuery();
				
				while (resultSet.next())
				{
					account.setAccountId(resultSet.getInt("accountId"));
					account.setAccountName(resultSet.getString("accountName"));
					account.setCardId(resultSet.getInt("cardId"));
					account.setLocation(resultSet.getString("location"));
				}
					
				
				return account;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(connection != null)
					{
						connection.close();
					}
					if(statement != null)
					{
						statement.close();
					}
					if(resultSet != null)
					{
						resultSet.close();
					}
				}catch (SQLException e) {
					return null;
				}
				
			}
		}
		return null;
	}

	
}
