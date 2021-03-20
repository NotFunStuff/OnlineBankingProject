package com.se2_project.group8C18.demoEBanking.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.ILoanService;
import com.se2_project.group8C18.demoEBanking.Model.Loan;
import com.se2_project.group8C18.demoEBanking.Repository.LoanRepository;

@Service
public class LoanService implements ILoanService {

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Autowired
	LoanRepository loanRepository;

	@Autowired
	InvestTypeService investService;

	@Override
	public Loan getLoan(int accountId) {
		if (investService.isEmpty(accountId)) {
			return null;
		} else {
			if (isEmpty(accountId)) {
				return null;
			}
			Loan lo = loanRepository.findById(investService.getInvest(accountId).getInvestTypeId()).get();
			return lo;
		}

	}

	@Override
	public String addLoan(String loan) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Loan lo = gson.fromJson(loan, Loan.class);
		if (investService.isEmpty(lo.getAccount().getAccountId())) {

			if (checkValidate.getOk(lo)) {
				loanRepository.save(lo);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(lo.getInvestTypeId());
		}
		return errorType.isExisted("invest");
	}

	@Override
	public String deleteLoan(int accountId) {
		if (investService.isEmpty(accountId)) {
			return errorType.isNotExisted("loan");

		}
		Loan loan = getLoan(accountId);
		if (loan.getAmount() == 0) {
			investService.deleteInvestType(accountId);
			return errorType.getSuccesful();
		}
		return errorType.getFail("loan ammount is not equal 0");

	}

	@Override
	public String editLoan(String loan) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Loan lo = gson.fromJson(loan, Loan.class);
		if (isEmpty(lo.getAccount().getAccountId())) {
			return errorType.isNotExisted("loan");
		} else {

			if (checkValidate.getOk(lo)) {
				Loan loanCurrent = getLoan(lo.getAccount().getAccountId());
				if (lo.getAmount() != loanCurrent.getAmount())
					loanCurrent.setAmount(lo.getAmount());
				if (lo.getDescription() != null)
					loanCurrent.setDescription(lo.getDescription());
				if (lo.getDuration() != loanCurrent.getDuration())
					loanCurrent.setDuration(lo.getDuration());
				if (lo.getRate() != loanCurrent.getRate())
					loanCurrent.setRate(lo.getRate());
				loanCurrent.setTimeCreated(LocalDateTime.now());
				loanRepository.save(loanCurrent);
				return errorType.getSuccesful();
			}
			return errorType.isValidated("loan");
		}
	}

	@Override
	public boolean isEmpty(int accountId) {
		if (loanRepository.existsById(investService.getInvest(accountId).getInvestTypeId())) {
			return false;
		}
		return true;
	}

}
