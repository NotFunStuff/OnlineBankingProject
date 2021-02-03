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

import org.hibernate.annotations.CreationTimestamp;

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
	private Account account;
	
	@Column(insertable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime time_created;
	
	@Column(nullable = false)
	private boolean verified;
	
	
}
