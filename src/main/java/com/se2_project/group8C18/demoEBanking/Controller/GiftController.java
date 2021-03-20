package com.se2_project.group8C18.demoEBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Model.Gift;
import com.se2_project.group8C18.demoEBanking.Service.GiftService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class GiftController {

	final String org = "http://127.0.0.1:5500";
	
	@Autowired
	GiftService giftService;
	
	@GetMapping(value = "/transaction/getAllGifts")
	@CrossOrigin(origins = org)
	public List<Gift> getAllGists(){
		return giftService.getAllGift();
	}
	
	@GetMapping(value = "/transaction/getGiftById")
	@CrossOrigin(origins = org)
	public Gift getGiftById(@RequestParam int giftId) {
		return giftService.getGiftById(giftId);
	}
	
	@GetMapping(value = "/transaction/getGiftByAccount")
	@CrossOrigin(origins = org)
	public List<Gift> getGiftsByAccount(@RequestParam int accountId){
		return giftService.getGiftsByAccount(accountId);
	}
	
	@PostMapping(value= "/transaction/addGift")
	@CrossOrigin(origins = org)
	public String addGift(@RequestBody String gift) {
		return giftService.addGift(gift);
	}
	
	@PutMapping(value= "/transaction/editGift")
	@CrossOrigin(origins = org)
	public String editGift(@RequestBody String gift) {
		return giftService.editGift(gift);
	}
	
	@DeleteMapping(value= "/transaction/deleteGiftById")
	@CrossOrigin(origins = org)
	public String deleteGiftById(@RequestParam int giftId) {
		return giftService.deleteGiftById(giftId);
	}
}
