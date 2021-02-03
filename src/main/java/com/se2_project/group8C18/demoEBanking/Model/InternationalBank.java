package com.se2_project.group8C18.demoEBanking.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table
@Entity
@PrimaryKeyJoinColumn(name = "internationalCardId")
public class InternationalBank extends Bank{
	
	@Column(nullable = false)
	private int cardNumber;
	
	@Column
	private LocalDateTime expiryDate;
	
	@Column(nullable = false)
	private String nameInCard;
}
