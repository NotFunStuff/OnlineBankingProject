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
@CrossOrigin(origins = "http://localhost:8080")
//@WebServlet(urlPatterns = { "/home", "/log-in" })
public class AccountController {

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
	public String addAccount(@RequestBody String account) {

		return accountService.addAccount(account);
	}
	
	@GetMapping(value = "/account/getAllAccounts")
	public List<Account> getAllAccounts() {
		return accountService.findAll();
	}

	@GetMapping(value = "/account/getAccountById")
	public Account getAccountById(@RequestParam int accountId) {
		return accountService.findById(accountId);
	}

	@PutMapping(value = "/account/editAccount")
	public String editAccount(@RequestBody String account) {
		return accountService.editAccount(account);
	}

	@DeleteMapping(value = "/account/deleteAccountById")
	public String deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}
	
	@GetMapping(value = "/account/getAccountByUserName")
	public Account getAccountByUserName(@RequestParam String userName) {
		return accountService.getAccountByUserName(userName);
	}
}
