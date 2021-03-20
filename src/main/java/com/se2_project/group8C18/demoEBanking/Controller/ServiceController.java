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

import com.se2_project.group8C18.demoEBanking.Model.Service;
import com.se2_project.group8C18.demoEBanking.Service.ServiceService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ServiceController {
	@Autowired
	ServiceService serviceService;
	
	@GetMapping(value = "/service/getAllServices")
	public List<Service> getAllServices() {
		return serviceService.getAllService();
	}
	
	@GetMapping(value = "/service/getServiceById")
	public Service getServiceById(@RequestParam int serviceId) {
		return serviceService.getServiceById(serviceId);
	}
	
	@GetMapping(value = "/service/getServiceByBusiness")
	public List<Service> getServicesByBusiness(int businessId){
		return serviceService.getServicesByBusiness(businessId);
	}
	
	@PostMapping(value = "/service/addService")
	public String addService(@RequestBody String service) {
		return serviceService.addService(service);
	}
	
	@PutMapping(value = "/service/editService")
	public String editService(@RequestBody String service) {
		return serviceService.editService(service);
	}
	
	@DeleteMapping(value= "/service/deleteServiceById")
	public String deleteService(@RequestParam int serviceId) {
		return serviceService.deleteServiceById(serviceId);
	}
}
