package com.se2_project.group8C18.demoEBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Model.Business;
import com.se2_project.group8C18.demoEBanking.Service.BusinessService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class BusinessController {

	@Autowired
	BusinessService businessService;
	
	@PostMapping(value = "/account/addBusiness")
	public String addBusiness(@RequestBody String business)
	{
		return businessService.addBusiness(business);
	}
	
	@GetMapping(value = "/account/getAllBusiness")
	public List<Business> getAllBusiness()
	{
		return businessService.getAllBusiness();
	}
	
	@GetMapping(value = "/account/getBusinessById")
	public Business getBusinessById(@RequestParam int businessId)
	{
		return businessService.getBusinessAccountById(businessId);
	}
	
	@DeleteMapping(value = "/account/deleteBusinessById")
	public String deleteBusinessById(@RequestParam int businessId)
	{
		return businessService.deleteBusinessById(businessId);
	}
	
	@PutMapping(value = "/account/editBusiness")
	public String editBusiness(@RequestBody String business)
	{
		return businessService.editBusiness(business);
	}
	
}
