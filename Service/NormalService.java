package com.se2_project.group8C18.demoEBanking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.INormalService;
import com.se2_project.group8C18.demoEBanking.Model.Normal;
import com.se2_project.group8C18.demoEBanking.Repository.AccountRepository;
import com.se2_project.group8C18.demoEBanking.Repository.NormalRepository;

@Service
public class NormalService implements INormalService {

	@Autowired
	NormalRepository normalRepository;

	@Autowired
	AccountService accountService;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Override
	public Normal getNormalById(int normalId) {
		if (normalRepository.existsById(normalId))
			return normalRepository.findById(normalId).get();
		return null;
	}

	@Override
	public List<Normal> getAllNormal() {

		return normalRepository.findAll();
	}

	@Override
	public String addNormal(String normal) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Normal nor = gson.fromJson(normal, Normal.class);

		if (!normalRepository.existsById(nor.getAccountId())) {
			if (checkValidate.getOk(nor)) {
				normalRepository.save(nor);
			}
			return errorType.isValidated(nor.getName());
		}
		return editNormal(normal);

	}

	@Override
	public String deleteNormalById(int normalId) {
		if (normalRepository.existsById(normalId)) {
			normalRepository.deleteById(normalId);
			return errorType.getSuccesful();
		}
		return "Normal " + errorType.isNotExisted(normalId);
	}

	@Override
	public String editNormal(String normal) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Normal nor = gson.fromJson(normal, Normal.class);

		if (normalRepository.existsById(nor.getAccountId())) {
			if (checkValidate.getOk(nor)) {
				Normal fixNor = getNormalById(nor.getAccountId());
				if (nor.getIdentityCard() != null)
					fixNor.setIdentityCard(nor.getIdentityCard());
				accountService.editAccount(normal);
				normalRepository.save(fixNor);
				return errorType.getSuccesful();
			}
		}

		return errorType.isNotExisted(nor.getName());
	}

}
