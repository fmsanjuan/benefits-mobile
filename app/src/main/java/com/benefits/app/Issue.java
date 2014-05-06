package com.benefits.app;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

public class Issue extends DomainEntity implements Serializable {

	private String description;

	// RelationShip
	private Customer customer;
	private Plan plan;

	public Issue() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonIgnore
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}
