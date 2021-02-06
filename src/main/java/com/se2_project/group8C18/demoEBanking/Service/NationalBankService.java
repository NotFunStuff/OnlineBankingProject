package com.se2_project.group8C18.demoEBanking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.INationalService;
import com.se2_project.group8C18.demoEBanking.Model.NationalBank;
import com.se2_project.group8C18.demoEBanking.Repository.NationalBankRepository;
import com.se2_project.group8C18.demoEBanking.Repository.PaymentMethodRepository;

@Service
public class NationalBankService implements INationalService {

	@Autowired
	NationalBankRepository nationalBankRepository;

	@Autowired
	PaymentMethodRepository paymentMethodRepository;

	@Autowired
	PaymentMethodService paymentMethodService;

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Override
	public NationalBank getNationalBankById(int nationalBankId) {
		return nationalBankRepository.findById(nationalBankId).get();
	}

	@Override
	public List<NationalBank> getAllNationalBank() {
		return nationalBankRepository.findAll();
	}

	@Override
	public String addNationalBank(String nationalBank) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		NationalBank na = gson.fromJson(nationalBank, NationalBank.class);

		if (!nationalBankRepository.existsById(na.getPaymentMethodId())) {
			if (checkValidate.getOk(na)) {
				nationalBankRepository.save(na);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(na.getBankName());
		}
		return editNationalBank(nationalBank);

	}

	@Override
	public String deleteNationalBankById(int nationalBankId) {
		if (nationalBankRepository.existsById(nationalBankId)) {
			nationalBankRepository.deleteById(nationalBankId);
			return errorType.getSuccesful();
		}
		return "National Bank " + errorType.isNotExisted(nationalBankId);
	}

	@Override
	public String editNationalBank(String nationalBank) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		NationalBank na = gson.fromJson(nationalBank, NationalBank.class);

		if (nationalBankRepository.existsById(na.getPaymentMethodId())) {
			if (checkValidate.getOk(na)) {
				NationalBank fixNa = getNationalBankById(na.getPaymentMethodId());
				if(na.getBankLogo() != null ) fixNa.setBankLogo(na.getBankLogo());
				if(na.getBankName() != null ) fixNa.setBankName(na.getBankName());
				if(na.getNameOnCard() != null) fixNa.setNameOnCard(na.getNameOnCard());
				
				paymentMethodService.editPaymentMethod(nationalBank);
				nationalBankRepository.save(fixNa);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(na.getBankName());
		}
		return errorType.isNotExisted(na.getBankName());
	}

}
