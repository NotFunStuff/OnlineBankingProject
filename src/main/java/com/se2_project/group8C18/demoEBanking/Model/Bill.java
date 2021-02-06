package com.se2_project.group8C18.demoEBanking.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table
@PrimaryKeyJoinColumn(name = "billId")
public class Bill extends Transaction {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int billId;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "accountId", foreignKey = @ForeignKey(name = "fk_account_bill"))
//	@JsonIgnoreProperties(value = "bills")
//	private Account account;
	
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime time_created;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serviceId", foreignKey = @ForeignKey(name = "fk_service_bill")) 
	@JsonIgnoreProperties(value = "bills")
	private Service service;




	public LocalDateTime getTime_created() {
		return time_created;
	}


	public void setTime_created(LocalDateTime time_created) {
		this.time_created = time_created;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}
	
	
	
}
