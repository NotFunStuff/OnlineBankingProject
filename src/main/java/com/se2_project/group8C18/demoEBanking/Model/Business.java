package com.se2_project.group8C18.demoEBanking.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
@PrimaryKeyJoinColumn(name = "bussinessId")
public class Business extends Account {
	
	
	@Column(nullable = false)
	private String businessName;
	
	@Column()
	private String location;
	
	@Column
	private String industry;

	
	@OneToMany(mappedBy = "business")
	@JsonIgnoreProperties(value = "business")
	private List<Service> services;


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getIndustry() {
		return industry;
	}


	public void setIndustry(String industry) {
		this.industry = industry;
	}


	public List<Service> getServices() {
		return services;
	}


	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
}
