package com.se2_project.group8C18.demoEBanking.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Table
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InvestType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investTypeId;
	
	@OneToOne
	@JoinColumn(name = "accountId", foreignKey = @ForeignKey(name = "fk_account_investType"))
	private Account account;
	
	@Column
	private String description;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime timeCreated;

	public int getInvestTypeId() {
		return investTypeId;
	}

	public void setInvestTypeId(int investTypeId) {
		this.investTypeId = investTypeId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	
	
}
