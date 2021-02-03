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
}
