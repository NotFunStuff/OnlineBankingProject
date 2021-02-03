package com.se2_project.group8C18.demoEBanking.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	
	@OneToOne(mappedBy = "bank")
	@JsonIgnoreProperties(value = "bank")
	private PaymentMethod paymentMethods;
	
	
}	
