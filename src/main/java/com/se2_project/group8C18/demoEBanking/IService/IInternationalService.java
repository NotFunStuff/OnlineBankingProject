package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.InternationalBank;

public interface IInternationalService {
	public InternationalBank getInternationalBankById(int internationalId );
	public List<InternationalBank> getAllInternationalBanks();
	public String addInternationalBank(String internationalBank);
	public String deleteInternationalBankById(int internationalId);
	public String editIternationalBank(String internationalBank);
}
