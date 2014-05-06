package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Training extends DomainEntity implements Serializable {

	private String name;
	private int duration;
	private String description;

	// Relationship
	private Collection<Plan> plans;
	private Collection<TrainingDay> trainingDays;
	private Sponsor sponsor;

	public Training() {
		super();

		plans = new ArrayList<Plan>();
		trainingDays = new ArrayList<TrainingDay>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Collection<Plan> getPlans() {
		return plans;
	}

	public void setPlans(Collection<Plan> plans) {
		this.plans = plans;
	}

	public Collection<TrainingDay> getTrainingDays() {
		return trainingDays;
	}

	public void setTrainingDays(Collection<TrainingDay> trainingDays) {
		this.trainingDays = trainingDays;
	}

	@JsonIgnore
	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
}
