package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.Business;

public interface IBusinessService {
	
	public Business getBusinessAccountById(int businessId);
	
	public List<Business> getAllBusiness();
	
	public String deleteBusinessById(int businessId);
	
	public String addBusiness(String business);
	
	public String editBusiness(String business);
	
	
	
}
