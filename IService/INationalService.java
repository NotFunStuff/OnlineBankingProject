package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.NationalBank;

public interface INationalService {
	public NationalBank getNationalBankById(int nationalBankId);
	public List<NationalBank> getAllNationalBank();
	public String addNationalBank(String nationalBank);
	public String deleteNationalBankById(int nationalBankId);
	public String editNationalBank(String nationalBank);
}
