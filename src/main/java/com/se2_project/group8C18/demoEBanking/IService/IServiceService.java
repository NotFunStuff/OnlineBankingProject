package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.Service;

public interface IServiceService {
	public Service getServiceById(int serviceId);
	public List<Service> getAllService();
	public String addService(String service);
	public String deleteServiceById(int serviceId);
	public String editService(String service);
}
