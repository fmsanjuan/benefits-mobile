package com.benefits.app;

import java.util.ArrayList;
import java.util.Collection;

public class Customer extends User {

	private double weight;
	private double height;
	private double bodyfat;
	private double waistlineMeasure;
	private double hipMeasure;
	private double chestMeasure;

	// RelationShip
	private Plan plan;
	private Collection<Issue> issues;

	public Customer() {
		super();
		issues = new ArrayList<Issue>();
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBodyfat() {
		return bodyfat;
	}

	public void setBodyfat(double bodyfat) {
		this.bodyfat = bodyfat;
	}

	public double getWaistlineMeasure() {
		return waistlineMeasure;
	}

	public void setWaistlineMeasure(double waistlineMeasure) {
		this.waistlineMeasure = waistlineMeasure;
	}

	public double getHipMeasure() {
		return hipMeasure;
	}

	public void setHipMeasure(double hipMeasure) {
		this.hipMeasure = hipMeasure;
	}

	public double getChestMeasure() {
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

	public Collection<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Collection<Issue> issues) {
		this.issues = issues;
	}

}
