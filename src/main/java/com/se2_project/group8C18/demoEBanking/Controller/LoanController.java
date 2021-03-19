package com.se2_project.group8C18.demoEBanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Model.Loan;
import com.se2_project.group8C18.demoEBanking.Service.LoanService;

@RestController
public class LoanController {
	
	final String org = "http://127.0.0.1:5500";
	
	@Autowired
	LoanService loanService;
	
	@GetMapping(value = "/loan/getLoan")
	@CrossOrigin(origins = org)
	public Loan getLoan(@RequestParam int accountId) {
		return loanService.getLoan(accountId);
	}
	
	@PostMapping(value = "/loan/addLoan")
	public String addLoan(@RequestBody String loan) {
		return loanService.addLoan(loan);
	}
	
	@DeleteMapping(value = "/loan/deleteLoan")
	public String deleteLoan(@RequestParam int accountId) {
		return loanService.deleteLoan(accountId);
	}
	
	@PutMapping(value = "/loan/editLoan")
	public String editLoan(@RequestBody String loan) {
		return loanService.editLoan(loan);
	}
}
