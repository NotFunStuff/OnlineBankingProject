package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import com.se2_project.group8C18.demoEBanking.Model.Gift;

public interface IGiftService {
	public Gift getGiftById(int giftId);
	public List<Gift> getAllGift();
	public String deleteGiftById(int giftId);
	public String addGift(String gift);
	public String editGift(String gift);
	
}
