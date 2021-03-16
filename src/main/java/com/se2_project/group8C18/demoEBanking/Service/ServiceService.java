package com.se2_project.group8C18.demoEBanking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.se2_project.group8C18.demoEBanking.Helper.CheckValidate;
import com.se2_project.group8C18.demoEBanking.Helper.ErrorType;
import com.se2_project.group8C18.demoEBanking.IService.IServiceService;
import com.se2_project.group8C18.demoEBanking.Model.Business;
import com.se2_project.group8C18.demoEBanking.Model.Service;
import com.se2_project.group8C18.demoEBanking.Repository.BusinessRepository;
import com.se2_project.group8C18.demoEBanking.Repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	BusinessRepository businessRepository;

	@Autowired
	BusinessService businessService;
	
	@Autowired
	BillService billService;

	@Autowired
	ErrorType errorType;

	@Autowired
	CheckValidate checkValidate;

	@Override
	public Service getServiceById(int serviceId) {
		if (serviceRepository.existsById(serviceId))
			return serviceRepository.findById(serviceId).get();
		return null;
	}

	@Override
	public List<Service> getAllService() {
		return serviceRepository.findAll();
	}

	/**
	 *
	 */
	@Override
	public String addService(String service) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Service ser = gson.fromJson(service, Service.class);

		if (businessRepository.existsById(ser.getBusiness().getAccountId())) {
			if (!serviceRepository.existsById(ser.getServiceId())) {
				if (checkValidate.getOk(ser)) {
					serviceRepository.save(ser);
					return errorType.getSuccesful();
				}
				return errorType.isValidated(ser.getServiceName());
			}
			return editService(service);
		}

		return "Business " + errorType.isNotExisted(ser.getBusiness().getAccountId());
	}

	@Override
	public String deleteServiceById(int serviceId) {
		if (serviceRepository.existsById(serviceId)) {
			Service ser = getServiceById(serviceId);
			ser.getBills().forEach(x -> billService.deleteBillById(x.getTransactionId()));
			serviceRepository.deleteById(serviceId);
			return errorType.getSuccesful();
		}

		return "Service " + errorType.isNotExisted(serviceId);
	}

	@Override
	public String editService(String service) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MMM/yyyy HH:mm:ss").create();
		Service ser = gson.fromJson(service, Service.class);

		if (serviceRepository.existsById(ser.getServiceId())) {
			if (checkValidate.getOk(ser)) {
				Service fixSer = getServiceById(ser.getServiceId());
				if (ser.getDescription() != null)
					fixSer.setDescription(ser.getDescription());
				if (ser.getServiceName() != null)
					fixSer.setServiceName(ser.getServiceName());
				
				serviceRepository.save(fixSer);
				return errorType.getSuccesful();
			}
			return errorType.isValidated(ser.getServiceName());
		}

		return errorType.isExisted(ser.getServiceName());
	}

	@Override
	public List<Service> getServicesByBusiness(int businessId) {
		List<Service> services = new ArrayList<Service>();
		Business bus = businessService.getBusinessAccountById(businessId);
		if(bus != null)
		{
			bus.getServices().forEach(x -> {
				services.add(x);
			});
		}
		return services;
	}

}
