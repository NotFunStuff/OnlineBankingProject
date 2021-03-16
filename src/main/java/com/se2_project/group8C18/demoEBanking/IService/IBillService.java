package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se2_project.group8C18.demoEBanking.Model.Bill;

@Service
public interface IBillService {

	public Bill getBillById(int billId);

	public List<Bill> getAllBills();

	public String addBill(String bill);

	public String deleteBillById(int billId);

	public String editBill(String bill);

	public List<Bill> getBillsByAccount(int accountId);
}
