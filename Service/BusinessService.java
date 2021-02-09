package com.se2_project.group8C18.demoEBanking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.IBusinessService;
import com.se2_project.group8C18.demoEBanking.Model.Business;
import com.se2_project.group8C18.demoEBanking.Repository.AccountRepository;
import com.se2_project.group8C18.demoEBanking.Repository.BusinessRepository;
import com.se2_project.group8C18.demoEBanking.Repository.ServiceRepository;

@Service
public class BusinessService implements IBusinessService {

	@Autowired
	BusinessRepository businessRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Autowired
	AccountService accountService;

	@Autowired
	ServiceService serviceService;

	@Override
	public Business getBusinessAccountById(int businessId) {
		if(businessRepository.existsById(businessId)) {
			return businessRepository.findById(businessId).get();
		}
		return null;
	}

	@Override
	public List<Business> getAllBusiness() {

		return businessRepository.findAll();
	}

	@Override
	public String deleteBusinessById(int businessId) {
		if (businessRepository.existsById(businessId)) {
			Business bus = getBusinessAccountById(businessId);
			bus.getServices().forEach(x -> serviceService.deleteServiceById(x.getServiceId()));
			businessRepository.deleteById(businessId);
			return errorType.getSuccesful();
		}
		return "Business " + errorType.isNotExisted(businessId);
	}

	/*
	 * @Effects : Add new business if(business is in AccountRep) add business else
	 * Add new account -> add business
	 * 
	 */
	@Override
	public String addBusiness(String business) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Business bus = gson.fromJson(business, Business.class);

		if (!businessRepository.existsById(bus.getAccountId())) {
			if (checkValidate.getOk(bus)) {
				businessRepository.save(bus);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(bus.getName());
		}
		return editBusiness(business);

	}

	/*
	 * @Effects : Edit Business if(business is in AccountRep) if(business is in
	 * BusinessRep) save business else return ErrorType
	 */
	@Override
	public String editBusiness(String business) {

		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Business bus = gson.fromJson(business, Business.class);
		if (accountRepository.existsById(bus.getAccountId())) {
			if (businessRepository.existsById(bus.getAccountId())) {
				if (checkValidate.getOk(bus)) {
					Business fixBus = getBusinessAccountById(bus.getAccountId());
					
					if(bus.getIndustry() != null ) fixBus.setIndustry(bus.getIndustry());
					if(bus.getBusinessName() !=null) fixBus.setBusinessName(bus.getBusinessName());
					if(bus.getLocation() != null) fixBus.setLocation(bus.getLocation());
					
					accountService.editAccount(business);
					
					businessRepository.save(fixBus);
					return errorType.getSuccesful();
				}
				return errorType.isValidated(bus.getName());
			}
			return errorType.isNotExisted(bus.getName());
		}

		return errorType.isNotExisted(bus.getName());
	}

}
