package com.se2_project.group8C18.demoEBanking.Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private Date dateOfBirth;
	
	
	@Column(insertable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime timeCreated;
	
	@Column
	private String avatar;
	
	
	@Column
	private String bio;
	
	
//	@OneToMany(mappedBy = "fromAccount")
//	@JsonIgnoreProperties(value = {"fromAccount", "toAccount"})
//	private List<Gift> fromGifts;
	
	@OneToMany(mappedBy = "toAccount")
	@JsonIgnoreProperties(value = {"fromAccount", "toAccount"})
	private List<Gift> toGifts;
	
//	@OneToMany(mappedBy = "account")
//	@JsonIgnoreProperties(value = "account")
//	private List<Bill> bills;
	
//	@OneToMany(mappedBy = "account")
//	@JsonIgnoreProperties(value = "account")
//	private List<Service> services;
	
	
	@OneToMany(mappedBy = "account")
	@JsonIgnoreProperties(value = "account")
	private List<PaymentMethod> paymentMethods;
	
	@OneToMany(mappedBy = "account")
	@JsonIgnoreProperties(value = "account")
	private List<Transaction> transactions;
}
