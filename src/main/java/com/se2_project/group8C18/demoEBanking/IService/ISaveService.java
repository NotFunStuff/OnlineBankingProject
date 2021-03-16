package com.se2_project.group8C18.demoEBanking.IService;

import com.se2_project.group8C18.demoEBanking.Model.Save;

public interface ISaveService {
	public Save getSave(int accountId);
	public String addSave(String save);
	public String deleteSave(int accountId);
	public String editSave(String save);
	public boolean isEmpty(int accountId);
}
