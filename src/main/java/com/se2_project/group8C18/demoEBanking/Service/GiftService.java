package com.se2_project.group8C18.demoEBanking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.IGiftService;
import com.se2_project.group8C18.demoEBanking.Model.Gift;
import com.se2_project.group8C18.demoEBanking.Repository.AccountRepository;
import com.se2_project.group8C18.demoEBanking.Repository.GiftRepository;
import com.se2_project.group8C18.demoEBanking.Repository.TransactionRepository;

@Service
public class GiftService implements IGiftService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	GiftRepository giftRepository;

	@Autowired
	TransactionService transactionService;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Override
	public Gift getGiftById(int giftId) {
		if(giftRepository.existsById(giftId))
			return giftRepository.findById(giftId).get();
		return null;
	}

	@Override
	public List<Gift> getAllGift() {

		return giftRepository.findAll();
	}

	@Override
	public String deleteGiftById(int giftId) {
		if (giftRepository.existsById(giftId)) {
			giftRepository.deleteById(giftId);
			return errorType.getSuccesful();
		}
		return "Gift " + errorType.isNotExisted(giftId + "");
	}

	@Override
	public String addGift(String gift) {

		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Gift gi = gson.fromJson(gift, Gift.class);

		if (accountRepository.existsById(gi.getAccount().getAccountId())) {

			if (!giftRepository.existsById(gi.getTransactionId())) {
				if (checkValidate.getOk(gi)) {
					
					
					giftRepository.save(gi);
					return errorType.getSuccesful();
				}
				return "Gift " + errorType.isValidated(gi.getTransactionId() + "");
			}
			return editGift(gift);

		}

		return "Account" + errorType.isNotExisted(gi.getAccount().getAccountId() + "");
	}

	@Override
	public String editGift(String gift) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Gift gi = gson.fromJson(gift, Gift.class);

		if (giftRepository.existsById(gi.getTransactionId())) {
			if (checkValidate.getOk(gi)) {
				Gift fixGift = getGiftById(gi.getTransactionId());
				giftRepository.save(fixGift);
				return errorType.getSuccesful();
			}
			return "Gift " + errorType.isValidated(gi.getTransactionId() + "");
		}
		return "Gift " + errorType.isNotExisted(gi.getTransactionId() + "");
	}
}
