package com.metro.rewards.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sales")
public class Sales {
	@Id
	@GeneratedValue
	private Long id;
	private String customerId;
	private String name;
	private Date salesDate;
	private Double salesAmount;
	
	public Sales() {
		super();
	}

	public Sales(Long id, String customerId, String name, Date salesDate, Double salesAmount) {
		super();
//		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.salesDate = salesDate;
		this.salesAmount = salesAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public Double getSalesAmount() {
		return salesAmount;
	}
	public void setsalesAmount(Double salesAmount) {
		this.salesAmount = salesAmount;
	}
	
	public String Sales() {
		return ("customerId=" + customerId + "; name=" + name + "; salesDate=" + salesDate + "; salesAmount=" + salesAmount);
	}

}