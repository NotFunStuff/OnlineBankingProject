package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se2_project.group8C18.demoEBanking.Model.Gift;
@Service
public interface IGiftService {
	public Gift getGiftById(int giftId);
	public List<Gift> getAllGift();
	public String deleteGiftById(int giftId);
	public String addGift(String gift);
	public String editGift(String gift);
	public List<Gift> getGiftsByAccount(int accountId);
}
