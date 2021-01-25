package com.ebanking.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ebanking.dao.INewDAO;

public class NewDAO implements INewDAO{

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ebanking?useSSL=false";
			String user= "root";
			String password = "trinhquanghuy19";
			return DriverManager.getConnection(url,user,password);
		}catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

}
