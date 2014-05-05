package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Training extends DomainEntity implements Serializable {

	private String name;
	private int duration;

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

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
}
