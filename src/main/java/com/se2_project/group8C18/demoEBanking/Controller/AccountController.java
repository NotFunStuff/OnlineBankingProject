package com.se2_project.group8C18.demoEBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//@WebServlet(urlPatterns = { "/home", "/log-in" })
public class AccountController {
	final String org = "http://127.0.0.1:5500";
	
	@Autowired
	IAccountService accountService;

//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		request.setAttribute("account", "hahak");
//		RequestDispatcher rd = request.getRequestDispatcher("/views/web/Home.jsp");
//		rd.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}

	@PostMapping(value = "/account/addAccount")
	@CrossOrigin(origins = org)
	public String addAccount(@RequestBody String account) {

		return accountService.addAccount(account);
	}
	
	@GetMapping(value = "/account/getAllAccounts")
	@CrossOrigin(origins = org)
	public List<Account> getAllAccounts() {
		return accountService.findAll();
	}

	@GetMapping(value = "/account/getAccountById")
	@CrossOrigin(origins = org)
	public Account getAccountById(@RequestParam int accountId) {
		return accountService.findById(accountId);
	}

	@PutMapping(value = "/account/editAccount")
	@CrossOrigin(origins = org)
	public String editAccount(@RequestBody String account) {
		return accountService.editAccount(account);
	}

	@DeleteMapping(value = "/account/deleteAccountById")
	@CrossOrigin(origins = org)
	public String deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}
	
	@GetMapping(value = "/account/getAccountByUserName")
	@CrossOrigin(origins = org)
	public Account getAccountByUserName(@RequestParam String userName) {
		return accountService.getAccountByUserName(userName);
	}
	
	@GetMapping(value = "/account/checkPhoneNumber")
	@CrossOrigin(origins = org)
	public boolean checkAccountByPhoneNumber(@RequestParam String phoneNumber) {
		return accountService.checkPhoneNumber(phoneNumber);
	}
	
	@GetMapping(value = "/account/getAccountByPhoneNumber")
	@CrossOrigin(origins = org)
	public Account getAccountByPhoneNumber(String phoneNumber) {
		return accountService.getAccountByPhoneNumber(phoneNumber);
	}
}
