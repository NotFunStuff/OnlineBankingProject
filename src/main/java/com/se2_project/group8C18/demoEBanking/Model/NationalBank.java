package com.se2_project.group8C18.demoEBanking.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table
@Entity
@PrimaryKeyJoinColumn(name = "nationalBankId")
public class NationalBank extends PaymentMethod{
	
	
	@Column(nullable = false)
	private String bankName;
	
	@Column(nullable = false)
	private String bankLogo;
	
	
	@Column(nullable = false)
	private String nameOnCard;


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getBankLogo() {
		return bankLogo;
	}


	public void setBankLogo(String bankLogo) {
		this.bankLogo = bankLogo;
	}


	public String getNameOnCard() {
		return nameOnCard;
	}


	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
}
