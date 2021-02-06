package com.se2_project.group8C18.demoEBanking.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.IService.IAccountService;
import com.se2_project.group8C18.demoEBanking.Model.Account;
	
@RestController
public class AccountController extends HttpServlet {
	
	@Autowired
	IAccountService accountService;
	
	
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		
//		request.setAttribute("account", accountService.findById(1));
//		RequestDispatcher rd = request.getRequestDispatcher("/views/web/Home.jsp");
//		rd.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}
	
	@PostMapping(value = "/account/addAccount")
	public String addAccount(@RequestBody String account)
	{
		return accountService.addAccount(account);
	}
	
	
	@GetMapping(value = "/account/getAllAccounts")
	public List<Account> getAllAccounts()
	{
		return accountService.findAll();
	}
	
	
	@GetMapping(value = "/account/getAccountById")
	public Account getAccountById(@RequestParam int accountId)
	{
		return accountService.findById(accountId);
	}
	
	@PutMapping(value = "/account/editAccount")
	public String editAccount(@RequestBody String account)
	{
		return accountService.editAccount(account);
	}
	
	@DeleteMapping(value = "/account/deleteAccountById")
	public String deleteAccountById(@RequestParam int accountId)
	{
		return accountService.deleteAccountById(accountId);
	}
}
