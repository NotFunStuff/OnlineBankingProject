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
	private String Industry;

	
	@OneToMany(mappedBy = "business")
	@JsonIgnoreProperties(value = "business")
	private List<Service> services;
	
	
}
