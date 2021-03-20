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
import com.se2_project.group8C18.demoEBanking.IService.IBillService;
import com.se2_project.group8C18.demoEBanking.Model.Account;
import com.se2_project.group8C18.demoEBanking.Model.Bill;
import com.se2_project.group8C18.demoEBanking.Repository.BillRepository;
import com.se2_project.group8C18.demoEBanking.Repository.ServiceRepository;
import com.se2_project.group8C18.demoEBanking.Repository.TransactionRepository;

@Service
public class BillService implements IBillService {

	@Autowired
	BillRepository billRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	AccountService accountService;
	
	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Autowired
	TransactionService transactionService;

	@Override
	public Bill getBillById(int billId) {
		if (billRepository.existsById(billId))
			return billRepository.findById(billId).get();
		return null;
	}

	@Override
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	/*
	 * @Effects : add Bill if bill is in serviceRep if bill is in transactionRep add
	 * bill else add new transaction , add bill; else return ErrorType
	 */
	@Override
	public String addBill(String bill) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Bill bil = gson.fromJson(bill, Bill.class);

		if (serviceRepository.existsById(bil.getService().getServiceId())) {

			if (!billRepository.existsById(bil.getTransactionId())) {
				if (checkValidate.getOk(bil)) {
					bil.setTime_created(LocalDateTime.now());
					com.se2_project.group8C18.demoEBanking.Model.Service sv = serviceRepository.findById(bil.getService().getServiceId()).get();
					bil.setPricetag(sv.getPriceTag());
					billRepository.save(bil);
					return errorType.getSuccesful();
				}
				return "Bill " + errorType.isValidated(bil.getTransactionId() + "");
			}
			return editBill(bill);

		}
		return "Service" + errorType.isNotExisted(bil.getService().getServiceId() + "");

	}

	@Override
	public String deleteBillById(int billId) {
		if (billRepository.existsById(billId)) {
			billRepository.deleteById(billId);
			return errorType.getSuccesful();
		}
		return "Bill " + errorType.isNotExisted(billId + "");
	}

	@Override
	public String editBill(String bill) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Bill bil = gson.fromJson(bill, Bill.class);
		if (billRepository.existsById(bil.getTransactionId())) {
			if (checkValidate.getOk(bil)) {
				Bill fixBill = getBillById(bil.getTransactionId());
				if (bil.getAccount() != null)
					fixBill.setAmount(bil.getAmount());
				transactionService.editTransaction(bill);
				billRepository.save(fixBill);
				return errorType.getSuccesful();
			}
			return "bill " + errorType.isValidated(bil.getTransactionId());
		}
		return "bill " + errorType.isNotExisted(bil.getTransactionId() + "");
	}

	@Override
	public List<Bill> getBillsByAccount(int accountId) {
		List<Bill> bills = new ArrayList<Bill>();
		Account acc = accountService.findById(accountId);
		if(acc != null)
		{
			acc.getTransactions().forEach(x -> {
				if(billRepository.existsById(x.getTransactionId()))
				{
					bills.add(getBillById(x.getTransactionId()));
				}
			});
		}
		return bills;
	}

}
