package com.se2_project.group8C18.demoEBanking.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "giftId")
public class Gift extends Transaction{

	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int giftId;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "fromAccountId", foreignKey = @ForeignKey(name = "fk_fromAccount_gift"))
//	@JsonIgnoreProperties(value = {"fromGifts", "toGifts"})
//	private Account fromAccount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "toAccountId" , foreignKey = @ForeignKey(name = "fk_toAccount_gift"))
	@JsonIgnoreProperties(value = {"fromGifts", "toGifts"})
	private Account toAccount;

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	
	
}
