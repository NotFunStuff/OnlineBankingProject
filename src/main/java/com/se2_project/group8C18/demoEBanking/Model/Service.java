package com.se2_project.group8C18.demoEBanking.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	
	@Column(nullable = false)
	private String serviceName;
	
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "businessId", foreignKey = @ForeignKey(name = "fk_business_service"))
	@JsonIgnoreProperties(value = "services")
	private  Business business;
	
	@OneToMany(mappedBy = "service")
	@JsonIgnoreProperties(value = "service")
	private List<Bill> bills;
	
	
}
