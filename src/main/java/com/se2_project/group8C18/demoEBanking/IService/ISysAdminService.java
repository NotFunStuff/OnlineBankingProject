package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se2_project.group8C18.demoEBanking.Model.SysAdmin;
@Service
public interface ISysAdminService {
	public SysAdmin getSysAdminById(int sysAdminId);
	
}
