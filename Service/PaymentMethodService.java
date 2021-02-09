package com.se2_project.group8C18.demoEBanking.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.IPaymentMethodService;
import com.se2_project.group8C18.demoEBanking.Model.Account;
import com.se2_project.group8C18.demoEBanking.Model.PaymentMethod;
import com.se2_project.group8C18.demoEBanking.Repository.AccountRepository;
import com.se2_project.group8C18.demoEBanking.Repository.InternationalBankRepository;
import com.se2_project.group8C18.demoEBanking.Repository.NationalBankRepository;
import com.se2_project.group8C18.demoEBanking.Repository.PaymentMethodRepository;
import com.se2_project.group8C18.demoEBanking.Repository.TransactionRepository;

@Service
public class PaymentMethodService implements IPaymentMethodService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	PaymentMethodRepository paymentMethodRepository;

	@Autowired
	TransactionService transactionService;

	@Autowired
	AccountService accountService;
	
	@Autowired
	NationalBankRepository nationalBankRepository;

	@Autowired
	InternationalBankRepository internationalBankRepository;

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Override
	public PaymentMethod getPaymentMethodById(int paymentMethodId) {
		if (paymentMethodRepository.existsById(paymentMethodId))
			return paymentMethodRepository.findById(paymentMethodId).get();
		return null;
	}

	@Override
	public List<PaymentMethod> getAllPaymentMethod() {

		return paymentMethodRepository.findAll();
	}

	@Override
	public String addPaymentMethod(String paymentMethod) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		PaymentMethod pay = gson.fromJson(paymentMethod, PaymentMethod.class);

		if (accountRepository.existsById(pay.getAccount().getAccountId())) {
			if (!paymentMethodRepository.existsById(pay.getPaymentMethodId())) {
				if (checkValidate.getOk(pay)) {
					pay.setTime_created(LocalDateTime.now());
					paymentMethodRepository.save(pay);
					return errorType.getSuccesful();
				}
				return "PaymentMethod " + errorType.isValidated(pay.getPaymentMethodId());
			}
			return editPaymentMethod(paymentMethod);
		}

		return "Account " + errorType.isNotExisted(pay.getAccount().getAccountId());
	}

	@Override
	public String deletePaymentMethodById(int paymentMethodId) {

		if (paymentMethodRepository.existsById(paymentMethodId)) {
			PaymentMethod pay = paymentMethodRepository.findById(paymentMethodId).get();

			transactionRepository.delete(pay.getTransaction());
			nationalBankRepository.deleteById(paymentMethodId);
			internationalBankRepository.deleteById(paymentMethodId);
			paymentMethodRepository.deleteById(paymentMethodId);
			return errorType.getSuccesful();
		}
		return "PaymentMethod " + errorType.isNotExisted(paymentMethodId);
	}

	@Override
	public String editPaymentMethod(String paymentMethod) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		PaymentMethod pay = gson.fromJson(paymentMethod, PaymentMethod.class);

		if (paymentMethodRepository.existsById(pay.getPaymentMethodId())) {
			if (checkValidate.getOk(pay)) {
				PaymentMethod fixPay = getPaymentMethodById(pay.getPaymentMethodId());
				if (pay.isVerified())
					fixPay.setVerified(pay.isVerified());
				paymentMethodRepository.save(pay);
				return errorType.getSuccesful();
			}
			return "PaymentMethod " + errorType.isValidated(pay.getPaymentMethodId());
		}
		return errorType.isNotExisted(pay.getPaymentMethodId());
	}

	@Override
	public List<PaymentMethod> getPaymentMethodsByAccount(int accountId) {
		Account acc =  accountService.findById(accountId);
		List<PaymentMethod> pays = new ArrayList<PaymentMethod>();
		if(acc!= null)
		{
			acc.getPaymentMethods().forEach(x -> pays.add(x));
		}
		return pays;
	}
	
	
	
}
