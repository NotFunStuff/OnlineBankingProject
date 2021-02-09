package com.se2_project.group8C18.demoEBanking.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table
@Entity
@PrimaryKeyJoinColumn(name = "internationalCardId")
public class InternationalBank extends PaymentMethod{
	
	@Column(nullable = false)
	private String cardNumber;
	
	@Column
	private LocalDateTime expiryDate;
	
	@Column(nullable = false)
	private String nameInCard;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNameInCard() {
		return nameInCard;
	}

	public void setNameInCard(String nameInCard) {
		this.nameInCard = nameInCard;
	}
	
	
}
