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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentMethod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentMethodId;
	
	@ManyToOne
	@JoinColumn(name = "accountId", foreignKey = @ForeignKey(name = "fk_account_paymentMethod"))
	@JsonIgnoreProperties(value = "paymentMethods")
	@JsonBackReference
	private Account account;
	
	@Column( updatable = false)
	@CreationTimestamp
	private LocalDateTime time_created;
	
	@Column(nullable = false)
	private boolean verified;

	@OneToOne(mappedBy = "paymentMethod")
//	@JsonIgnoreProperties(value = {"paymentMethod", "account"})
	@Transient
	private Transaction transaction;
	
	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LocalDateTime getTime_created() {
		return time_created;
	}

	public void setTime_created(LocalDateTime time_created) {
		this.time_created = time_created;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
}
