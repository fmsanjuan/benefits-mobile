package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;


public class Plan extends DomainEntity implements Serializable {

	private String name;
	private Goals goal;
	private String description;
	private Double minWeight;
	private Double maxWeight;
	private Double minBodyFat;
	private Double maxBodyFat;

	// RelationShip
	private Collection<Issue> issues;
	private Collection<Customer> customers;
	private Diet diet;
	private Training training;
	private Collection<Comment> comments;

	public Plan() {
		super();
		customers = new ArrayList<Customer>();
		comments = new ArrayList<Comment>();
		issues = new ArrayList<Issue>();
	}

	public Goals getGoal() {
		return goal;
	}

	public void setGoal(Goals goal) {
		this.goal = goal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(Double minWeight) {
		this.minWeight = minWeight;
	}

	public Double getMaxWeight() {
		return maxWeight;
	}

	
	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public Double getMinBodyFat() {
		return minBodyFat;
	}

	public void setMinBodyFat(Double minBodyFat) {
		this.minBodyFat = minBodyFat;
	}

	public Double getMaxBodyFat() {
		return maxBodyFat;
	}

	public void setMaxBodyFat(Double maxBodyFat) {
		this.maxBodyFat = maxBodyFat;
	}

	@JsonIgnore
	public Collection<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Collection<Issue> issues) {
		this.issues = issues;
	}

	@JsonIgnore
	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	@JsonIgnore
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

}
