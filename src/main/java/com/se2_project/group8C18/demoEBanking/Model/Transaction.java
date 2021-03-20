package com.se2_project.group8C18.demoEBanking.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	@Column(nullable = false)
	@Min(value = 0)
	private long amount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", foreignKey = @ForeignKey(name = "fk_account_transaction"))
	@JsonIgnoreProperties(value = "transactions")
	private Account account;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentMethodId", foreignKey = @ForeignKey(name = "fk_paymentMethod_transaction"))
	private PaymentMethod paymentMethod;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime timeCreated;
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	
	
}
