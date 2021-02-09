package com.se2_project.group8C18.demoEBanking.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.se2_project.group8C18.demoEBanking.IService.ISysAdminService;
import com.se2_project.group8C18.demoEBanking.Model.SysAdmin;
import com.se2_project.group8C18.demoEBanking.Repository.SysAdminRepository;

public class SysAdminService implements ISysAdminService{

	@Autowired
	SysAdminRepository sysAdminRepository;
	
	@Override
	public SysAdmin getSysAdminById(int sysAdminId) {
		
		return sysAdminRepository.findById(sysAdminId).get();
	}
	
}
