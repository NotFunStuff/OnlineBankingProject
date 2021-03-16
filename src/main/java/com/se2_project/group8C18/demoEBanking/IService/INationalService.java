package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se2_project.group8C18.demoEBanking.Model.NationalBank;
@Service
public interface INationalService {
	public NationalBank getNationalBankById(int nationalBankId);
	public List<NationalBank> getAllNationalBank();
	public String addNationalBank(String nationalBank);
	public String deleteNationalBankById(int nationalBankId);
	public String editNationalBank(String nationalBank);
}
