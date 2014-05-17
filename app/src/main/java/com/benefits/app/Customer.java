package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;


public class Customer extends User implements Serializable {

	private Double weight;
	private Double height;
	private Double bodyfat;
	private Double waistlineMeasure;
	private Double hipMeasure;
	private Double chestMeasure;

	// RelationShip
	private Plan plan;
	private Collection<Issue> issues;

	public Customer() {
		super();
		issues = new ArrayList<Issue>();
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Double getBodyfat() {
		return bodyfat;
	}

	public void setBodyfat(double bodyfat) {
		this.bodyfat = bodyfat;
	}

	public Double getWaistlineMeasure() {
		return waistlineMeasure;
	}

	public void setWaistlineMeasure(double waistlineMeasure) {
		this.waistlineMeasure = waistlineMeasure;
	}

	public Double getHipMeasure() {
		return hipMeasure;
	}

	public void setHipMeasure(double hipMeasure) {
		this.hipMeasure = hipMeasure;
	}

	public Double getChestMeasure() {
		return chestMeasure;
	}

	public void setChestMeasure(Double chestMeasure) {
		this.chestMeasure = chestMeasure;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@JsonIgnore
	public Collection<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Collection<Issue> issues) {
		this.issues = issues;
	}

}
