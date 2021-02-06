package com.se2_project.group8C18.demoEBanking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.IInternationalService;
import com.se2_project.group8C18.demoEBanking.Model.InternationalBank;
import com.se2_project.group8C18.demoEBanking.Repository.InternationalBankRepository;
import com.se2_project.group8C18.demoEBanking.Repository.PaymentMethodRepository;

@Service
public class InternationalService implements IInternationalService {

	@Autowired
	InternationalBankRepository internationalRepository;

	@Autowired
	PaymentMethodRepository paymentMethodRepository;

	@Autowired
	PaymentMethodService paymentMethodService;

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Override
	public InternationalBank getInternationalBankById(int internationalId) {
		if(internationalRepository.existsById(internationalId))	
			return internationalRepository.findById(internationalId).get();
		return null;
	}

	@Override
	public List<InternationalBank> getAllInternationalBanks() {

		return internationalRepository.findAll();
	}

	@Override
	public String addInternationalBank(String internationalBank) {

		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		InternationalBank in = gson.fromJson(internationalBank, InternationalBank.class);

		if (internationalRepository.existsById(in.getPaymentMethodId())) {
			if (checkValidate.getOk(in)) {
				internationalRepository.save(in);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(in.getNameInCard());
		}
		return editIternationalBank(internationalBank);

	}

	@Override
	public String deleteInternationalBankById(int internationalId) {

		if (internationalRepository.existsById(internationalId)) {
			internationalRepository.deleteById(internationalId);
			return errorType.getSuccesful();
		}
		return "Internation bank " + errorType.isNotExisted(internationalId);
	}

	@Override
	public String editIternationalBank(String internationalBank) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		InternationalBank in = gson.fromJson(internationalBank, InternationalBank.class);

		if (internationalRepository.existsById(in.getPaymentMethodId())) {
			if(checkValidate.getOk(in))
			{
				InternationalBank fixIn = getInternationalBankById(in.getPaymentMethodId());
				if(in.getCardNumber()!= null) fixIn.setCardNumber(in.getCardNumber());
				if(in.getExpiryDate()!= null) fixIn.setExpiryDate(in.getExpiryDate());
				if(in.getNameInCard()!= null) fixIn.setNameInCard(in.getNameInCard());
				
				paymentMethodService.editPaymentMethod(internationalBank);
				
				internationalRepository.save(fixIn);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(in.getNameInCard());
		}

		return errorType.isNotExisted(in.getNameInCard());
	}

}
