package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import org.codehaus.jackson.annotate.JsonIgnore;

public class Diet extends DomainEntity implements Serializable {

	private String name;
	private String description;
	private Language entityLanguage;

	// Relationship

	private Collection<Plan> plans;
	private Collection<Day> days;
	private Sponsor sponsor;

	public Diet() {
		super();

		plans = new ArrayList<Plan>();
		days = new ArrayList<Day>();
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

	@JsonIgnore
	public Collection<Plan> getPlans() {
		return plans;
	}

	public void setPlans(Collection<Plan> plans) {
		this.plans = plans;
	}

	public Collection<Day> getDays() {
		return days;
	}

	public void setDays(Collection<Day> days) {
		this.days = days;
	}

	@JsonIgnore
	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public Language getEntityLanguage() {
		return entityLanguage;
	}

	public void setEntityLanguage(Language entityLanguage) {
		this.entityLanguage = entityLanguage;
	}

}
