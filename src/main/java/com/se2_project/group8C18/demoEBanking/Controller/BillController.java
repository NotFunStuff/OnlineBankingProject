package com.se2_project.group8C18.demoEBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Model.Bill;
import com.se2_project.group8C18.demoEBanking.Service.BillService;

@RestController
public class BillController {
	
	final String org = "http://127.0.0.1:5500";
	
	@Autowired
	BillService billService;
	
	@PostMapping(value = "/transaction/addBill")
	@CrossOrigin(origins = org)
	public String addBill(@RequestBody String bill)
	{
		return billService.addBill(bill);
	}
	
	@DeleteMapping(value = "/transaction/deleteBillById")
	@CrossOrigin(origins = org)
	public String deleteBillById(@RequestParam int billId)
	{
		return billService.deleteBillById(billId);
	}
	
	@GetMapping(value = "/transaction/getAllBills")
	@CrossOrigin(origins = org)
	public List<Bill> getAllBills()
	{
		return billService.getAllBills();
	}
	
	@GetMapping(value = "/transaction/getBillById")
	@CrossOrigin(origins = org)
	public Bill getBillById(@RequestParam int billId)
	{
		return billService.getBillById(billId);
	}
}
